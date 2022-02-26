package patient.service;

import java.util.Map;

public class WriteRequest {
	private String patientID;
	private String diagnosis;
	private String prescription;
	
	public WriteRequest(String patientID, String diagnosis, String prescription) {
		this.patientID = patientID;
		this.diagnosis = diagnosis;
		this.prescription = prescription;
	}

	public String getPatientID() {
		return patientID;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getPrescription() {
		return prescription;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if (patientID == null) {
			System.out.println("patientID == null");
			errors.put("patientID", Boolean.TRUE);
		}
	}
	
}
