package es.iestetuan.bav.dao;

import java.util.List;

import es.iestetuan.bav.vo.Departamentos;
import es.iestetuan.bav.vo.Empleados;

public interface EmpleadosDao {

	public void  crearEmpleado( Empleados empleados);
	public Empleados consultarEmpleado(int emp_no );
	public void borrarEmpleado (Integer emp_no );
	public void modificarEmpleado(Empleados empleados);
	public List<Empleados> consultarEmpleadosApellidoSalario(String apellido, Float salario);
}
