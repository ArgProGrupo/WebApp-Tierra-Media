package services;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.Propuestas;
import persistence.commons.FactoryDAO;

public class PromocionService {
	
	public List<Propuestas> list() {
		return FactoryDAO.getPromocionDAO().findAll();
	}
	
//	public void delete(Integer id) {
//		FactoryDAO.getPromocionDAO().delete(id);
//	}
	
	public void delete(Integer id) {
		FactoryDAO.getPromocionDAO().delete(id);
	}
	
	public Promocion update(Integer id, String nombrePropuesta, Integer descuento, String tipoPromo, String tipo) {
		Promocion promocion = new Promocion(id, nombrePropuesta, descuento, tipoPromo, tipo);
		if(promocion.isValid()) {
			FactoryDAO.getPromocionDAO().update(promocion);
		}
		return promocion;
	}
	
	public Promocion findById(Integer id) {
		return FactoryDAO.getPromocionDAO().findByIdPromo(id);
	}

	public Promocion create(Integer id, String nombrePropuesta, Integer descuento, String tipoPromo, String tipo) {
		Promocion promocion = new Promocion(id, nombrePropuesta, descuento, tipoPromo, tipo);

		if (promocion.isValid()) {
			//AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
			FactoryDAO.getPromocionDAO().insert(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}
	
//	public static void main(String[] args) throws ServletException {
//		AtraccionService a = new AtraccionService();
//		System.out.println(a.list());	
//	}
	
}
