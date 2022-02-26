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
import jdbc.JdbcUtil;

public class DeleteDoctorService {

	private DoctorDao doctorDao = new DoctorDao();

	public void deleteMember(DeleteDoctorRequest delMemReq) throws NamingException {
		System.out.println("deleteMember");
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			conn.setAutoCommit(false);

			System.out.println("DeleteMemberService db");
			// id 중복 체크: 중복이면 롤백하고 익셉션 처리
			Doctors doctors = doctorDao.selectById(conn, delMemReq.getDocID());
			
			if (doctors == null || (!doctors.getDocPW().equals(delMemReq.getDocPW()))) {
				JdbcUtil.rollback(conn);// 사실 할 필요없음
				throw new InvalidPasswordException();
			}
			System.out.println("delMemReq");
			
			// 중복이 아니면 insert해서 join. DB에 저장 (DTO인 Member 객체 생성하고 값 넣어서 DAO에 insert메소드 호출)
			doctorDao.delete(conn, doctors);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
