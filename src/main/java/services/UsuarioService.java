package services;

import java.util.List;

import model.Usuario;
import persistence.commons.FactoryDAO;

public class UsuarioService {
	
	public List<Usuario> list() {
		return FactoryDAO.getUsuarioDAO().findAll();
	}
	
	public void delete(Integer id) {
		FactoryDAO.getUsuarioDAO().delete(id);
	}
	
	public Usuario update(Integer id, String nombre, String password, Boolean admin, String atraccionFavorita, Integer presupuesto, Double tiempo, Boolean active) {
		Usuario usuario = new Usuario(id, nombre, password, admin, atraccionFavorita, presupuesto, tiempo, active);
		usuario.setPassword(password);
		if(usuario.isValid()) {
			FactoryDAO.getUsuarioDAO().update(usuario);
		}
		return usuario;
	}
	
	
	public Usuario findById(Integer id) {
		return FactoryDAO.getUsuarioDAO().findByIdUsuario(id);
	}


	public Usuario create(String nombre, String password, Integer admin, String atraccionFavorita, Integer presupuesto, Double tiempoDisponible, Integer active) {
		Usuario usuario = new Usuario(-1, nombre, password, admin, atraccionFavorita, presupuesto, tiempoDisponible, active);
		usuario.setPassword(password);

		if (usuario.isValid()) {
			FactoryDAO.getUsuarioDAO().insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}
	
//	public static void main(String[] args) {
//		System.out.println(UsuarioService.list());
//	}
}
