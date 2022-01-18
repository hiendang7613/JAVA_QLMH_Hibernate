package pojo;

public class Class_Subject implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String classID;
	private String subjectID;
	private String classRoom;
	
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getClassID() {
		return classID;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	
	public Class_Subject(String classID, String subjectID, String classRoom) {
		super();
		this.classID = classID;
		this.subjectID = subjectID;
		this.classRoom = classRoom;
	}	
	public Class_Subject() {
		super();
		this.classID = "";
		this.subjectID = "";
		this.classRoom = "";
	}

}
