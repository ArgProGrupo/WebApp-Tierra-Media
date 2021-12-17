package services;

import java.util.List;

import model.Atraccion;
import model.Propuestas;
import persistence.commons.FactoryDAO;

public class AtraccionService {
	
	public List<Propuestas> list() {
		return FactoryDAO.getAtraccionDAO().findAll();
	}
	
	public void delete(Atraccion a) {
		FactoryDAO.getAtraccionDAO().delete(a);
	}
	
	public Atraccion update(Integer id, String nombrePropuesta, Integer costo, Double tiempo, Integer cupo, String tipo) {
		Atraccion atraccion = new Atraccion(id, nombrePropuesta, costo, tiempo, cupo, tipo);
		if(atraccion.isValid()) {
			FactoryDAO.getAtraccionDAO().update(atraccion);
		}
		return atraccion;
	}
	
	public Atraccion findById(Integer id) {
		return FactoryDAO.getAtraccionDAO().findByIdAtraccion(id);
	}

	public Atraccion create(String nombrePropuesta, Integer costo, Double tiempo, Integer cupo, String tipo) {
		Atraccion atraccion = new Atraccion(-1, nombrePropuesta, costo, tiempo, cupo, tipo);

		if (atraccion.isValid()) {
			//AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
			FactoryDAO.getAtraccionDAO().insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}
	
//	public static void main(String[] args) throws ServletException {
//		AtraccionService a = new AtraccionService();
//		System.out.println(a.list());	
//	}
	
}
