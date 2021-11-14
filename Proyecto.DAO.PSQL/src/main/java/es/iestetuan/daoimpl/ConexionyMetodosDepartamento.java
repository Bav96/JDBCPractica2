package es.iestetuan.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.iestetuan.bav.dao.DepartamentosDao;
import es.iestetuan.bav.vo.Departamentos;

public class ConexionyMetodosDepartamento implements DepartamentosDao  {

	

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
	public void crearDepartamento(Departamentos departamentos) {
		Connection conn = null;
	       Departamentos departamento = null;
		
	      
	        try {
	          
	            // abrir la conexion 
	        	Connection conexion =getConexion();
	            // generar la query
	            String query = "insert into departamentos values(?, ?, ?)";
	            // preparar el statement, introduciendo los datos
	            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
	                // enviar el commando insert
	                        stmt.setInt(1, Departamentos.getDept_no());
	                        stmt.setString(2, Departamentos.getDnombre());
	                        stmt.setString(3, Departamentos.getloc());
	                        
	                        // ejecutar la sentencia
	                        stmt.executeUpdate();
	                        System.out.println("Datos creados");
	            }
	        } catch (SQLException e) {
	            // si algo sale mal lanzar la excepción
	            throw new RuntimeException(e);
	        } finally {
	            if (conn != null) {
	                try {
	                    // cerrar conexión
	                    conn.close();
	                } catch (SQLException e) {
	                    // si algo falla al cerrar la conexión enviar salida
	                    e.getMessage();
	                }
	            }
	        }
	        }
		  

	

	

	@Override
	public Departamentos consultarDepartamento(int dept_no) {
		// TODO Auto-generated method stub
		Connection conn = null;
       Departamentos departamento = null;

        try {
        	Connection conexion =getConexion();
            
            try (PreparedStatement ps = conexion.prepareStatement(
                    "select * from departamentos where dept_no = ?")) {
                // indicar el ID que buscamos
                ps.setInt(1, dept_no);
                // ejecutar la consulta
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // obtener cada una de la columnas y mapearlas a la clase Product
                        departamento = new Departamentos(dept_no,
                                rs.getString("dnombre"),
                                rs.getString("loc"));
                    }
                }
            }
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
        return departamento;
}
	

	@Override
	public void borrarDepartamentos(Integer Dept_no) {
		Connection conn = null;
	       Departamentos departamento = null;
		
		try {
           
            // abrir la conexion 
			Connection conexion =getConexion();
			try (Statement stmt = conexion.createStatement()) {
                // enviar el comando delete
                stmt.executeUpdate("delete from departamentos where dept_no = " + Dept_no + ";");
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
	public void modificarDepartamento(Departamentos departamentos) {
		Connection conn = null;
	       Departamentos departamento = null;
		
	      
	        try {
	          
	            // abrir la conexion 
	        	Connection conexion =getConexion();
	            // generar la query
	            String query = ("UPDATE departamentos SET dnombre=?, loc=? WHERE dept_no=?");
	            // preparar el statement, introduciendo los datos
	            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
	                // enviar el commando insert
	                        
	                        stmt.setString(1, Departamentos.getDnombre());
	                        stmt.setString(2, Departamentos.getloc());
	                        stmt.setInt(3, Departamentos.getDept_no());
	                        
	                        // ejecutar la sentencia
	                        stmt.executeUpdate();
	                        System.out.println("Datos modificados");
	            }
	        } catch (SQLException e) {
	            // si algo sale mal lanzar la excepción
	            throw new RuntimeException(e);
	        } finally {
	            if (conn != null) {
	                try {
	                    // cerrar conexión
	                    conn.close();
	                } catch (SQLException e) {
	                    // si algo falla al cerrar la conexión enviar salida
	                    e.getMessage();
	                }
	            }
	        }
	}

	
}