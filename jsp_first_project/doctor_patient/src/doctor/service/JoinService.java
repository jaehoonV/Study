package doctor.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import doctor.dao.DoctorDao;
import doctor.model.Doctors;
import doctor.service.exception.DuplicateIdException;
import jdbc.JdbcUtil;

//서비스 : 컨트롤러의 호출을 받아 매개변수로 받은 값 등을 이용해 과제 처리 알고리즘
// -- 주로 dao를 호출하여 db에 데이터를 입출력하고 그 결과를 처리하여 컨트롤러로 반환

//id 중복 체크하고 아니면 회원으로 등록(db에 insert)
public class JoinService {

	private DoctorDao doctorDao = new DoctorDao();

	public void join(JoinRequest joinReq) throws NamingException {
		System.out.println("join");
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			conn.setAutoCommit(false);

			System.out.println("db");
			// docID 중복 체크: 중복이면 롤백하고 익셉션 처리
			Doctors doctor = doctorDao.selectById(conn, joinReq.getDocID());
			if (doctor != null) {
				System.out.println("doctor 중복체크");
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			// 아니면 db에 저장(DTO인 Member 객체 생성하고 값 넣어서 dao의 insert 호출)
			doctorDao.insert(conn, new Doctors(joinReq.getDocID(), joinReq.getDocPW(), joinReq.getDocName(),
					joinReq.getMedicalDepartment(), joinReq.getPhoneNum()));

			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
