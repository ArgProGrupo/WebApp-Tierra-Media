package persistence;

import java.util.List;


import model.Promocion;
import model.Propuestas;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Propuestas>{
	public abstract List<Propuestas> findAll(List<Propuestas> atracciones);
	public abstract Promocion findByIdPromo(int idPromo);
	public abstract List<Promocion> findByNombrePack(String nombre);
	public abstract List<Promocion> findByDescuento(String tipoPromo);
	public abstract int delete(Integer id);

}
