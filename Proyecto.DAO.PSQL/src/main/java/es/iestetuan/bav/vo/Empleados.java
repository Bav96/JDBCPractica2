package es.iestetuan.bav.vo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleados {

	public static int getEmp_no() {
		return emp_no;
	}
	public static void setEmp_no(int emp_no) {
		Empleados.emp_no = emp_no;
	}
	public static String getApellido() {
		return apellido;
	}
	public static void setApellido(String apellido) {
		Empleados.apellido = apellido;
	}
	public static String getOficio() {
		return oficio;
	}
	public static void setOficio(String oficio) {
		Empleados.oficio = oficio;
	}
	public static int getDir() {
		return dir;
	}
	public static void setDir(int dir) {
		Empleados.dir = dir;
	}
	public static float getSalario() {
		return salario;
	}
	public static void setSalario(float salario) {
		Empleados.salario = salario;
	}
	public static int getComision() {
		return comision;
	}
	public static void setComision(int comision) {
		Empleados.comision = comision;
	}
	public static int getDept_no() {
		return dept_no;
	}
	public static void setDept_no(int dept_no) {
		Empleados.dept_no = dept_no;
	}
	public static int emp_no;
	public static String apellido;
	public static String oficio;
	public static int dir;
	public static float salario;
	public static int comision;
	public static int dept_no;
	public static Date fecha_alt;
	
	
	
	
	public static Date getFecha_alt() {
		return fecha_alt;
	}
	public static void setFecha_alt(Date fecha_alt) {
		Empleados.fecha_alt = fecha_alt;
	}
	public Empleados (int emp_no,String apellido,String oficio,int dir,Date fecha_alt,float salario, int comision, int dept_no) {
		this.emp_no=emp_no;
		this.apellido=apellido;
		this.oficio=oficio;
		this.dir=dir;
		this.fecha_alt=fecha_alt;
		this.salario=salario;
		this.comision=comision;
		this.dept_no=dept_no;
	}
		
}	

