package pojo;

public class Subject implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String iD;
	private String name;
	
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Subject(String iD, String name) {
		super();
		this.iD = iD;
		this.name = name;
	}	
	public Subject() {
		super();
		this.iD = "";
		this.name = "";
	}
	
}
