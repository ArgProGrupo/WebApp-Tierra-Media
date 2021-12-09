package services;

import model.Usuario;
import nullobjects.NullUsuario;
import persistence.UsuarioDAO;
import persistence.commons.FactoryDAO;

public class LoginService {
	
	public Usuario login(String nombre, String password) {
		UsuarioDAO usuarioDao = FactoryDAO.getUsuarioDAO();
		Usuario usuario = usuarioDao.findByNombre(nombre);
		
		if (usuario.isNull() || !usuario.checkPassword(password)) {
			usuario = NullUsuario.build();
		}
		return usuario;
	}
}
