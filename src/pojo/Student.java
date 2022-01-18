package pojo;

public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String studentID;
	private String name;
	private String gender;
	private String iD;
	private String classID;
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {

		this.iD = iD;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Student(String studentID, String name, String gender, String iD, String classID) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.gender = gender;
		this.iD = iD;
		this.classID = classID;
	}
	
	public Student() {
		super();
		this.studentID = "";
		this.name = "";
		this.gender = "";
		this.iD = "";
		this.classID = "";
	}
	
	
	
}
