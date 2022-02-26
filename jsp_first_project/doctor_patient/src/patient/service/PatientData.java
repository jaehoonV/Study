package patient.service;


import patient.model.Patients;
import patient.model.PatientsContent;

public class PatientData {
	
	private Patients patients;
	private PatientsContent diagnosis;
	private PatientsContent prescription;

	public PatientData(Patients patients, PatientsContent diagnosis, PatientsContent prescription) {
		this.patients = patients;
		this.diagnosis = diagnosis;
		this.prescription = prescription;
	}

	public Patients getPatients() {
		return patients;
	}

	public String getDiagnosis() {
		return diagnosis.getDiagnosis();
	}
	
	public String getPrescription() {
		return prescription.getPrescription();
	}


}
