package es.iestetuan.bav.dao;

import es.iestetuan.bav.vo.*;


public interface DepartamentosDao {

		public void  crearDepartamento(Departamentos departamentos);
		public Departamentos consultarDepartamento(int dept_no);
		public void borrarDepartamentos (Integer Dept_no);
		public void modificarDepartamento(Departamentos departamentos);
		
	
	
}
