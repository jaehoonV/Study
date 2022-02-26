package doctor.service;

import java.util.Map;

public class DeleteDoctorRequest {
	private String docID;
	private String docPW;
	
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
	
		public void validate(Map<String, Boolean> errors) {
			//폼에서 입력받은 값이 있는지 체크하고 없으면 errors에 항목 이름과 TRUE 입력
			checkEmpty(errors, docID, "docID");
			checkEmpty(errors, docPW, "docPW");
			
		}
		
		//폼의 각 항목에 값이 있는지 확인하고 없으면 errors라는 맵에 항목 이름과 True를 입력
		private void checkEmpty(Map<String, Boolean> errors, 
				String value, String fieldName) {
			if (value == null || value.isEmpty())
				errors.put(fieldName, Boolean.TRUE);
		}
}
