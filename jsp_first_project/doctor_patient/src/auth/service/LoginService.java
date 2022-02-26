package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import doctor.dao.DoctorDao;
import doctor.model.Doctors;

public class LoginService {
	
	private DoctorDao doctorDao = new DoctorDao();

	public User login(String docID, String docPW) throws NamingException {
		System.out.println("LoginService ");
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		
		try {
			conn = ds.getConnection();
			System.out.println("LoginService 로그인 db");
			Doctors doctors = doctorDao.selectById(conn, docID);
			if (doctors == null) {
				throw new LoginFailException();
			}
			if (!doctors.matchPassword(docPW)) {
				throw new LoginFailException();
			}
			return new User(doctors.getDocID(), doctors.getDocName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
