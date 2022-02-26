package doctor.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import doctor.dao.DoctorDao;
import doctor.model.Doctors;
import doctor.service.exception.InvalidPasswordException;
import doctor.service.exception.MemberNotFoundException;
import jdbc.JdbcUtil;


public class ChangePasswordService {

	private DoctorDao doctorDao = new DoctorDao();
	
	public void changePassword(String docId, String curPwd, String newPwd) throws NamingException {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			System.out.println("ChangePasswordService db");
			Doctors doctors = doctorDao.selectById(conn, docId);
			if (doctors == null) {
				throw new MemberNotFoundException();
			}
			if (!doctors.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			System.out.println("ChangePasswordService");
			doctors.changePassword(newPwd);
			doctorDao.update(conn, doctors);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
