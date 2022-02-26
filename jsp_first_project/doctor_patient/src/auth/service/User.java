package auth.service;

public class User {

	private String docID;
	private String docName;

	public User(String docID, String docName) {
		this.docID = docID;
		this.docName = docName;
	}

	public String getDocID() {
		return docID;
	}

	public String getDocName() {
		return docName;
	}

}
