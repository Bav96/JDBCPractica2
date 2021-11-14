package es.iestetuan.daoimpl;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.iestetuan.bav.dao.EmpleadosDao;
import es.iestetuan.bav.vo.Departamentos;
import es.iestetuan.bav.vo.Empleados;

public class ConexionyMetodosEmpleados implements EmpleadosDao{
	public static Connection getConexion() {
		Connection conexion = null;
        try
        {
        	Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://dam2.actividad.cf/aadd-dam2" , "aadd" , "d1m2p0sgr3sql");
            if (conexion != null)            
                System.out.println("Connected");           
            else          
                System.out.println("Not Connected");         
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return conexion;
    }

	@Override
	public void crearEmpleado(Empleados empleados) {
		

        // abrir la conexion 
    		Connection conexion =getConexion();
	        try {
	        	
	          
	            // generar la query
	            String query = "insert into empleados values(?, ?, ?,?,?,?,?,?)";
	            // preparar el statement, introduciendo los datos
	            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
	                // enviar el commando insert
	                        stmt.setInt(1, empleados.getEmp_no());
	                        stmt.setString(2, empleados.getApellido());
	                        stmt.setString(3, empleados.getOficio());
	                        stmt.setInt(4, empleados.getDir());
	                        //Tenemos que convertir date e importar su calse en la clase conexion y añadir la clase .gettime y crear un objeto java.sql
	                        stmt.setDate(5,new java.sql.Date( empleados.getFecha_alt().getTime())); 
	                        stmt.setFloat(6, empleados.getSalario());
	                        stmt.setInt(7,empleados.getComision());
	                        stmt.setInt(8, empleados.getDept_no());
	                        // ejecutar la sentencia
	                        stmt.executeUpdate();
	                        System.out.println("Datos creados");
	            }
	        } catch (SQLException e) {
	            // si algo sale mal lanzar la excepción
	            throw new RuntimeException(e);
	        } finally {
	            if (conexion != null) {
	                try {
	                    // cerrar conexión
	                    conexion.close();
	                } catch (SQLException e) {
	                    // si algo falla al cerrar la conexión enviar salida
	                    e.getMessage();
	                }
	            }
	        }
		
	}

	
		
	

	@Override
	public void borrarEmpleado(Integer emp_no) {
		Connection conn = null;
	       Departamentos departamento = null;
		
		try {
        
         // abrir la conexion 
			Connection conexion =getConexion();
			try (Statement stmt = conexion.createStatement()) {
             // enviar el comando delete
             stmt.executeUpdate("delete from empleados where emp_no = " + emp_no + ";");
         }
			System.out.print("Datos borrados");
     } catch (SQLException e) {
         throw new RuntimeException(e);
     } finally {
         if (conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }
		
	}

	@Override
	public void modificarEmpleado(Empleados empleados) {
		// TODO Auto-generated method stub
		
		// abrir la conexion 
    	Connection conexion =getConexion();
		
	      
	        try {
	          
	            
	            // generar la query
	            String query = ("UPDATE empleados SET salario=?, dept_no=? WHERE emp_no=?");
	            // preparar el statement, introduciendo los datos
	            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
	                // enviar el commando insert
	                        
	                        stmt.setFloat(1,Empleados.getSalario());
	                        stmt.setInt(2, Empleados.getDept_no());
	                        stmt.setInt(3, Empleados.getEmp_no());
	                        
	                        // ejecutar la sentencia
	                        stmt.executeUpdate();
	                        System.out.println("Datos modificados");
	            }
	        } catch (SQLException e) {
	            // si algo sale mal lanzar la excepción
	            throw new RuntimeException(e);
	        } finally {
	            if (conexion != null) {
	                try {
	                    // cerrar conexión
	                    conexion.close();
	                } catch (SQLException e) {
	                    // si algo falla al cerrar la conexión enviar salida
	                    e.getMessage();
	                }
	            }
	        }
	        }

	@Override
	public List<Empleados> consultarEmpleadosApellidoSalario(String apellido, Float salario) {
		List<Empleados>Ellistadodelosempleadosdevueltos= new ArrayList();
		Connection conexion =getConexion();
	       Empleados empleado = null;

	        try {
	        	
	            
	            try (PreparedStatement ps = conexion.prepareStatement(
	                    "select * from empleados where apellido  like ?  and salario > ? ")) {
	            	//SELECT * FROM  empleados WHERE  apellido LIKE 'J%' AND salario >1500
	                // indicar el ID que buscamos
	                ps.setString(1, apellido+"%");
	                ps.setFloat(2, salario);
	                // ejecutar la consulta
	                try (ResultSet rs = ps.executeQuery()) {
	                    if (rs.next()) {
	                        // obtener cada una de la columnas y mapearlas a la clase Product
	                        empleado= new Empleados (
	                                rs.getInt("emp_no"),
	                        		rs.getString("apellido"),
	                                rs.getString("oficio"),
	                        		rs.getInt("dir"),
	                        		new java.util.Date(rs.getDate("fecha_alt").getTime()),
	                        		rs.getFloat("salario"),
	                        		rs.getInt("comision"),
	                        		rs.getInt("dept_no"));
	                        
	                        Ellistadodelosempleadosdevueltos.add(empleado);
	                        		
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            if (conexion != null) {
	                try {
	                    conexion.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		
		
		
		return Ellistadodelosempleadosdevueltos ;
		
	}
		
	

	



	@Override
	public Empleados consultarEmpleado(int emp_no) {
		// TODO Auto-generated method stub
		Connection conexion =getConexion();
	       Empleados empleado = null;

	        try {
	        	
	            
	            try (PreparedStatement ps = conexion.prepareStatement(
	                    "select * from empleados where emp_no = ?")) {
	                // indicar el ID que buscamos
	                ps.setInt(1, emp_no);
	                // ejecutar la consulta
	                try (ResultSet rs = ps.executeQuery()) {
	                    if (rs.next()) {
	                        // obtener cada una de la columnas y mapearlas a la clase Product
	                        empleado= new Empleados (emp_no,
	                                rs.getString("apellido"),
	                                rs.getString("oficio"),
	                        		rs.getInt("dir"),
	                        		new java.util.Date(rs.getDate("fecha_alt").getTime()),
	                        		rs.getFloat("salario"),
	                        		rs.getInt("comision"),
	                        		rs.getInt("dept_no"));
	                        		
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            if (conexion != null) {
	                try {
	                    conexion.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return empleado;
	}
		
	
}
