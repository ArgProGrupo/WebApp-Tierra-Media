package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Atraccion;
import model.Propuestas;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.commons.FactoryDAO;

public class ComprarAtraccionService {
	
	AtraccionDAO atraccionDAO = FactoryDAO.getAtraccionDAO();
	UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
	
	public Map<String, String> comprar(Integer idUsuario, Integer idAtraccion) {
		Map<String, String> errores = new HashMap<String, String>();
		
		Usuario usuario = usuarioDAO.findByIdUsuario(idUsuario);
		Atraccion atraccion = atraccionDAO.findByIdAtraccion(idAtraccion);
		
		if (!usuario.puedeComprar(atraccion)) {
			errores.put("usuario", "No se puede comprar");
		}
		
		if (usuario.puedeComprar(atraccion)) {
			usuario.comprarPropuesta(atraccion);
		}
		
		return errores;
	}
	
}
