package AADD.BAV.Proyecto.DAO.PSQL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.iestetuan.bav.dao.DepartamentosDao;
import es.iestetuan.bav.dao.EmpleadosDao;
import es.iestetuan.bav.vo.Departamentos;
import es.iestetuan.bav.vo.Empleados;
import es.iestetuan.daoimpl.*;
public class MainEmpleados {
	public static void main(String[] args) throws ParseException {
		
		
		
		
	    EmpleadosDao Empleados = new ConexionyMetodosEmpleados();
	    SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-mm-dd"); 
	    int sueldo= 10;
	    float sueldoenfloat = sueldo;
	        // agregar nuevo empleado
	      // Empleados.crearEmpleado(new Empleados (8001,"Justo","PROF.MP",7782, objSDF.parse("2021-11-10") ,sueldoenfloat,0,50));
	        
	        // obtener el empleado con numero de empleado =8001
 
	        //Empleados E = Empleados.consultarEmpleado(8001);
	        //System.out.println("Este es su apellido:  " +E.getApellido());
	        //System.out.println("Este es su ofico:  " +E.getOficio());
	    	//System.out.println("Este es su salario :" +E.getSalario());
	        
	    	//Empleados.modificarEmpleado(new Empleados (7369,"","",0,  new Date() ,sueldoenfloat,0,50) );
	    	
	    	List<Empleados> ResultadoConsulta = Empleados.consultarEmpleadosApellidoSalario("J", sueldoenfloat);
	    	
	    	for ( Empleados resultado : ResultadoConsulta ) {
	    		System.out.println("Este es su apellido:  "+resultado.getApellido());
		        System.out.println("Este es su ofico:  " +resultado.getOficio());
		    	System.out.println("Este es su salario :" +resultado.getSalario());
	    		
	    		
	    	}
	    	
	    
	    
	    
	        // eliminar el empleado con dept_no = 7469
	       // Empleados.borrarEmpleado( 7499);
	    }
}
