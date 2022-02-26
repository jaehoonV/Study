package doctor.service;

import java.util.Map;
//회원가입 폼에서 넘어오는 값을 받아주는 커맨드 객체이자 입력폼의 값을 검증(validation)하는 클래스
public class JoinRequest {

	private String docID;
	private String docPW;
	private String docName;
	private String medicalDepartment;
	private String phoneNum;
	private String confirmPassword;
	
	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getDocPW() {
		return docPW;
	}

	public void setDocPW(String docPW) {
		this.docPW = docPW;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getMedicalDepartment() {
		return medicalDepartment;
	}

	public void setMedicalDepartment(String medicalDepartment) {
		this.medicalDepartment = medicalDepartment;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	// 두 번 입력 받은 패스워드가 서로 일치하는지 검증
	public boolean isPasswordEqualToConfirm() {
		return docPW != null && docPW.equals(confirmPassword);
	}
	
	//폼 입력값 검증 - 보통 javascript에서 하는 일을 jsp에서 처리
	public void validate(Map<String, Boolean> errors) {
		//폼에서 입력받은 값이 있는지 체크하고 없으면 errors에 항목 이름과 TRUE 입력
		checkEmpty(errors, docID, "docID");
		checkEmpty(errors, docPW, "docPW");
		checkEmpty(errors, confirmPassword, "confirmPassword"); //패스워드 두 번 입력 받은 패스워드가 서로 일치하는지 검증
		checkEmpty(errors, docName, "docName");
		checkEmpty(errors, medicalDepartment, "medicalDepartment");
		checkEmpty(errors, phoneNum, "phoneNum");
		
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	//폼의 각 항목에 값이 있는지 확인하고 없으면 errors라는 맵에 항목 이름과 True를 입력
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
