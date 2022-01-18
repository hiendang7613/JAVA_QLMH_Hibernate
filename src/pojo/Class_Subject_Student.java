package pojo;

public class Class_Subject_Student implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String classID;
	private String subjectID;
	private String studentID;
	private float diemGK;
	private float diemCK;
	private float diemCong;
	private float diemTB;
	
	public float getDiemGK() {
		return diemGK;
	}
	public void setDiemGK(float diemGK) {
		this.diemGK = diemGK;
	}
	public float getDiemCK() {
		return diemCK;
	}
	public void setDiemCK(float diemCK) {
		this.diemCK = diemCK;
	}
	public float getDiemCong() {
		return diemCong;
	}
	public void setDiemCong(float diemCong) {
		this.diemCong = diemCong;
	}
	public float getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {	
		this.classID = classID;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	

	
	public Class_Subject_Student(String classID, String subjectID, String studentID, float diemGK, float diemCK,
			float diemCong, float diemTB) {
		super();
		this.classID = classID;
		this.subjectID = subjectID;
		this.studentID = studentID;
		this.diemGK = diemGK;
		this.diemCK = diemCK;
		this.diemCong = diemCong;
		this.diemTB = diemTB;
	}
	
	public Class_Subject_Student() {
		super();
		this.classID = "";
		this.subjectID = "";
		this.studentID = "";
		this.diemGK = 0;
		this.diemCK = 0;
		this.diemCong = 0;
		this.diemTB = 0;
	}
	
}
