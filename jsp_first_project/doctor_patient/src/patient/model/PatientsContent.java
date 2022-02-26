package patient.model;

public class PatientsContent {
	
	private String ID;
	private String diagnosis;
	private String prescription;

	public PatientsContent(String ID, String diagnosis, String prescription) {
		this.ID = ID;
		this.diagnosis = diagnosis;
		this.prescription = prescription;
	}

	public String getID() {
		return ID;
	}

	public String getDiagnosis() {
		return diagnosis;
	}
	
	public String getPrescription() {
		return prescription;
	}
}
