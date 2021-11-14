package AADD.BAV.Proyecto.DAO.PSQL;
import es.iestetuan.bav.dao.DepartamentosDao;
import es.iestetuan.bav.vo.Departamentos;
import es.iestetuan.daoimpl.*;
public class MainDepartamentos {

	public static void main(String[] args) {
		
		
		
		
    DepartamentosDao Departamentos = new ConexionyMetodosDepartamento();
        
        // agregar nuevo departamento
       // Departamentos.crearDepartamento(new Departamentos(60, "Comunicaciones", "Madrid"));
       // Departamentos.crearDepartamento(new Departamentos(70, "Informatica", "Madrid"));
        // obtener el departamento con ID = 50
        Departamentos D = Departamentos.consultarDepartamento(50);
        System.out.println("Este es el numero de departamento:  " +D.getDept_no());
        System.out.println("Este es el nombre del departamento:  " +D.getDnombre());
        System.out.println("Esta en esta localidad:  " +D.getloc());
        
    	
        //newDepartamentos.modificarDepartamento(new Departamentos (60,"Informatica y Comunicaciones","Bilbao"));
    	//Departamentos.modificarDepartamento(new Departamentos (50,"TIC",""));
    
    
    
        // eliminar eldepartamento con dept_no = 60
        //Departamentos.borrarDepartamentos( 60);
    }

		
		
    }


