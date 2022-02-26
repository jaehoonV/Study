package patient.service;

import java.util.Map;

public class RegisterRequest {
	private String patientID;
	private String patientName;
	
	
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, patientID, "patientID");
		checkEmpty(errors, patientName, "patientName");
		
	}
	
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
