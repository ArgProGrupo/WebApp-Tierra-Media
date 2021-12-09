package persistance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Propuestas;
import model.Usuario;
import persistance.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract Usuario findByIdUsuario(int idUsuario);
	public abstract Usuario findByNombre(String nombre);
	public abstract List<Usuario> findByTipoFavorito(String atraccionFavorita);
	public abstract List<Usuario> findByPresupuesto(int presupuesto);
	public abstract List<Usuario> findByTiempoDisponible(double tiempoDisponible);
	//public abstract int delete(Usuario t);
	public ArrayList<Propuestas> saveItinerario(Usuario u) throws SQLException;
	public abstract int delete(Integer id);
}
