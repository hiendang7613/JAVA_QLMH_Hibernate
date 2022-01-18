package pojo;

public class Class implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String iD;

	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}


	public Class(String iD) {
		super();
		this.iD = iD;
	}	
	
	public Class() {
		super();
		this.iD = "";
	}
}
