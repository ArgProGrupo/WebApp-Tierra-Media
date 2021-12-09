package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Propuestas;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract Usuario findByIdUsuario(Integer idUsuario);
	public abstract Usuario findByNombre(String nombre);
	public abstract List<Usuario> findByTipoFavorito(String atraccionFavorita);
	public abstract List<Usuario> findByPresupuesto(Integer presupuesto);
	public abstract List<Usuario> findByTiempoDisponible(Double tiempoDisponible);
	//public abstract int delete(Usuario t);
	public ArrayList<Propuestas> saveItinerario(Usuario u) throws SQLException;
	public abstract int delete(Integer id);
}
