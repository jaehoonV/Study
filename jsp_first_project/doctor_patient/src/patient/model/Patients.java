package patient.model;

public class Patients {
	
	private String patientID;
	private String patientName;
	private String diagnosis;
	private String prescription;
	private String p_docID;
	
	public Patients(String patientID, String patientName, String diagnosis, String prescription, String p_docID) {
		this.patientID = patientID;
		this.patientName = patientName;
		this.diagnosis = diagnosis;
		this.prescription = prescription;
		this.p_docID = p_docID;
	
	}

	public Patients(String patientID, String patientName) {
		this.patientID = patientID;
		this.patientName = patientName;
	}

	public String getPatientID() {
		return patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getPrescription() {
		return prescription;
	}

	public String getP_docID() {
		return p_docID;
	}
	
	

}
