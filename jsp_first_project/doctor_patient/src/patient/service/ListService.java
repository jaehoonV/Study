package patient.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import patient.dao.PatientDao;
import patient.model.Patients;

public class ListService {

	private PatientDao patientDao = new PatientDao();
	private int size = 5;

	public ListPage getListPage(int pageNum) throws NamingException {
		System.out.println("ListService");
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("ListService db");
			
			// 전체 게시물 개수 - 페이지 수를 정하기 위해
			int total = patientDao.selectCount(conn);
			List<Patients> content = patientDao.select(conn, (pageNum - 1) * size, size);
			return new ListPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
