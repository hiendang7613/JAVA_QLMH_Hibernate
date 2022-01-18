package pojo;

public class Account {
	private String username;
	private String password;
	private boolean isGiaovu;
	private String studentID;
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public boolean getIsGiaovu() {
		return isGiaovu;
	}
	public void setIsGiaovu(boolean isGiaovu) {
		this.isGiaovu = isGiaovu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Account(String username, String password, boolean isGiaovu, String studentID) {
		super();
		this.username = username;
		this.password = password;
		this.isGiaovu = isGiaovu;
		this.studentID = studentID;
	}
	
	public Account() {
		super();
		this.username = "";
		this.password = "";
		this.isGiaovu = false;
		studentID ="";
	}
	

}
