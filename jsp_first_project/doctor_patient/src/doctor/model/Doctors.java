package doctor.model;

public class Doctors {
	
	private String docID;
	private String docPW;
	private String docName;
	private String medicalDepartment;
	private String phoneNum;
	
	public Doctors(String docID, String docPW, String docName, String medicalDepartment, String phoneNum) {
		super();
		this.docID = docID;
		this.docPW = docPW;
		this.docName = docName;
		this.medicalDepartment = medicalDepartment;
		this.phoneNum = phoneNum;
	}

	public String getDocID() {
		return docID;
	}

	public String getDocPW() {
		return docPW;
	}

	public String getDocName() {
		return docName;
	}

	public String getMedicalDepartment() {
		return medicalDepartment;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public boolean matchPassword(String docPWD) {
		return docPW.equals(docPWD);
	}

	public void changePassword(String newPwd) {
		System.out.println("Doctors >> changePassword");
		this.docPW = newPwd;
	}
	
	
}
