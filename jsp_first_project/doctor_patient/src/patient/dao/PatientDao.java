package patient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import patient.model.Patients;

public class PatientDao {

	// patientID로 환자 정보 가져오기 - patientID 중복 확인
	public Patients selectById(Connection conn, String patientID) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from Patients where patientID = ?");
			pstmt.setString(1, patientID);
			rs = pstmt.executeQuery();
			Patients patients = null;
			if (rs.next()) {
				System.out.println("patientID db >> rs.next() = true");
				patients = convertPatients(rs);
			}
			return patients;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	/* 환자 등록 : service로부터 커넥션과 멤버 객체를 받아서 처리 */
	public void insert(Connection conn, Patients pat) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into Patients(patientID, patientName) values(?,?)")) {
			pstmt.setString(1, pat.getPatientID());
			pstmt.setString(2, pat.getPatientName());

			pstmt.executeUpdate();
		}
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from Patients");
			if (rs.next()) {
				System.out.println("PatientDao >> selectCount");
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public List<Patients> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM(" + 
					"    SELECT A.*, ROWNUM AS RNUM FROM(" + 
					"        SELECT * FROM Patients ORDER BY patientid) " + 
					"        A WHERE ROWNUM <= ?+?)" + 
					"WHERE RNUM > ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			pstmt.setInt(3, startRow);
			
			rs = pstmt.executeQuery();
			List<Patients> result = new ArrayList<>();
			System.out.println("PatientDao >> select");
			while (rs.next()) {
				result.add(convertPatients(rs));
				System.out.println("PatientDao >> select >> convertPatients1");
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Patients convertPatients(ResultSet rs) throws SQLException {
		System.out.println("PatientDao >> select >> convertPatients2");
		return new Patients(rs.getString("patientID"),rs.getString("patientName"),rs.getString("diagnosis"),
				rs.getString("prescription"),rs.getString("p_docID"));
	}

	public int update(Connection conn,String patientID, String diagnosis, String prescription) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update Patients set diagnosis = ?, prescription = ? "+
						"where patientID = ?")) {
			pstmt.setString(1, diagnosis);
			pstmt.setString(2, prescription);
			pstmt.setString(3, patientID);
			return pstmt.executeUpdate();
		}
	}
	
	
}
