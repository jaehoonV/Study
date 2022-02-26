package doctor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import doctor.model.Doctors;

public class DoctorDao {

	// docID로 의사 정보 가져오기 - docID 중복 확인, 로그인 등에 사용
	public Doctors selectById(Connection conn, String docID) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from Doctors where docID = ?");
			pstmt.setString(1, docID);
			rs = pstmt.executeQuery();
			System.out.println("로그인 select db");
			Doctors doctor = null;
			if (rs.next()) {
				doctor = new Doctors(rs.getString("docID"), rs.getString("docPW"), rs.getString("docName"),
						rs.getString("medicalDepartment"), rs.getString("phoneNum"));
			}
			return doctor;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	/* 의사 등록 : service로부터 커넥션과 멤버 객체를 받아서 처리 - 커넥션 닫는 일은 service에서 함 */
	public void insert(Connection conn, Doctors doc) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("insert into Doctors values(?,?,?,?,?)")) {
			pstmt.setString(1, doc.getDocID());
			pstmt.setString(2, doc.getDocPW());
			pstmt.setString(3, doc.getDocName());
			pstmt.setString(4, doc.getMedicalDepartment());
			pstmt.setString(5, doc.getPhoneNum());
			pstmt.executeUpdate();
		}
	}

	/* 의사정보 수정: docID로 확인하여 이름과 패스워드 수정 */
	public void update(Connection conn, Doctors doc) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update Doctors set docName = ?, docPW = ? where docID = ?")) {
			pstmt.setString(1, doc.getDocName());
			pstmt.setString(2, doc.getDocPW());
			pstmt.setString(3, doc.getDocID());
			pstmt.executeUpdate();
		}
	}

	/* 의사 탈퇴: */
	public void delete(Connection conn, Doctors doc) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from Doctors where docID = ?")) {
			pstmt.setString(1, doc.getDocID());
			pstmt.executeUpdate();
		}
	}

}
