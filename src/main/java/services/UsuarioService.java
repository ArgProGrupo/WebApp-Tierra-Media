package services;

import java.util.List;

import model.Usuario;
import persistence.commons.FactoryDAO;

public class UsuarioService {
	public List<Usuario> list() {
		return FactoryDAO.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, String password, Boolean admin, String atraccionFavorita, Integer presupuesto, Double tiempoDisponible, Boolean active) {
		Usuario usuario = new Usuario(-1, nombre, password, admin, atraccionFavorita, presupuesto, tiempoDisponible, active);
		usuario.setPassword(password);

		if (usuario.isValid()) {
			FactoryDAO.getUsuarioDAO().insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}
}
