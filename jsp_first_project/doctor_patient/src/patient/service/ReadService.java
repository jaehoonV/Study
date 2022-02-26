package patient.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import patient.dao.PatientContentDao;
import patient.dao.PatientDao;
import patient.model.Patients;
import patient.model.PatientsContent;
import patient.service.exception.PatientContentNotFoundException;
import patient.service.exception.PatientNotFoundException;

public class ReadService {

	private PatientDao patientDao = new PatientDao();
	private PatientContentDao contentDao = new PatientContentDao();

	public PatientData getPatient(String ID) throws NamingException {
		System.out.println("ReadService");
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("ReadService db");
			// ID로 환자 조회하여 객체로 반환 받음
			Patients patients = patientDao.selectById(conn, ID);
			if (patients == null) {
				throw new PatientNotFoundException();
			}
			PatientsContent diagnosis = contentDao.selectById(conn, ID);
			if (diagnosis == null) {
				throw new PatientContentNotFoundException();
			}
			PatientsContent prescription = contentDao.selectById(conn, ID);
			if (prescription == null) {
				throw new PatientContentNotFoundException();
			}
			return new PatientData(patients, diagnosis, prescription);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
