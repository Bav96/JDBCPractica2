package es.iestetuan.bav.vo;

public class Departamentos {
	
	private static int dept_no;
	
	public static int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public static String getDnombre() {
		return dnombre;
	}
	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}
	public static String getloc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	private static String dnombre; 
	
	
	private static String loc;
	
	public Departamentos (int dept_no, String dnombre, String loc) {
	this.dept_no=dept_no;
	this.dnombre=dnombre;
	this.loc=loc;
		
	}
	
	
}
