package patient.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdbc.JdbcUtil;
import patient.dao.PatientContentDao;
import patient.dao.PatientDao;
import patient.model.Patients;
import patient.service.exception.PatientNotFoundException;
import patient.service.exception.PermissionDeniedException;

public class WriteService {
	
	private PatientDao patientDao = new PatientDao();
	private PatientContentDao contentDao = new PatientContentDao();

	public void write(WriteRequest wtReq) throws NamingException {
		
		System.out.println("WriteService");
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			System.out.println("WriteService db");
		
			Patients patients = patientDao.selectById(conn, 
					wtReq.getPatientID());
			if (patients == null) {
				System.out.println("patients == null");
				throw new PatientNotFoundException();
			} 
			patientDao.update(conn, wtReq.getPatientID(), wtReq.getDiagnosis(), wtReq.getPrescription());
			contentDao.update(conn, wtReq.getPatientID(), wtReq.getDiagnosis(), wtReq.getPrescription());
			
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
