package patient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import patient.model.PatientsContent;

public class PatientContentDao {

	public PatientsContent insert(Connection conn, PatientsContent patcon) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into Patients_content(ID, diagnosis, prescription) values (?,?,?)");
			pstmt.setString(1, patcon.getID());
			pstmt.setString(2, patcon.getDiagnosis());
			pstmt.setString(3, patcon.getPrescription());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return patcon;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
	}

	public PatientsContent selectById(Connection conn, String ID) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("PatientContentDao >> selectById");
		try {
			pstmt = conn.prepareStatement("select * from Patients_content where ID = ?");
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			PatientsContent content = null;
			if (rs.next()) {
				System.out.println("PatientContentDao >> selectById >> rs.next() = true");
				content = new PatientsContent(rs.getString("ID"), rs.getString("diagnosis"), rs.getString("prescription"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int update(Connection conn, String ID, String diagnosis, String prescription) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update Patients_content set diagnosis = ?, prescription = ? "
						+ "where ID = ?")) {
			pstmt.setString(1, diagnosis);
			pstmt.setString(2, prescription);
			pstmt.setString(3, ID);
			return pstmt.executeUpdate();
		}
	}

	public int delete(Connection conn, String ID) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from Patients_content where ID = ?")) {
			pstmt.setString(1, ID);
			return pstmt.executeUpdate();
		}
	}
}
