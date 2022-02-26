package patient.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import doctor.service.exception.DuplicateIdException;
import jdbc.JdbcUtil;
import patient.dao.PatientContentDao;
import patient.dao.PatientDao;
import patient.model.Patients;
import patient.model.PatientsContent;

public class RegisterService {

	private PatientDao patientDao = new PatientDao();
	private PatientContentDao contentDao = new PatientContentDao();

	public void register(RegisterRequest registerReq) throws NamingException {
		System.out.println("register");
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			conn.setAutoCommit(false);

			System.out.println("db");
			// docID 중복 체크: 중복이면 롤백하고 익셉션 처리
			Patients patients = patientDao.selectById(conn, registerReq.getPatientID());
			if (patients != null) {
				System.out.println("patients 중복체크");
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			} else {
			// 아니면 db에 저장(DTO인 Member 객체 생성하고 값 넣어서 dao의 insert 호출)
			patientDao.insert(conn, new Patients(registerReq.getPatientID(), registerReq.getPatientName()));
			contentDao.insert(conn, new PatientsContent(registerReq.getPatientID(), null, null));
			
			}
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
