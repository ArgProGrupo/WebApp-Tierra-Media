package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Atraccion;
import model.Promocion;
import model.Propuestas;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.commons.FactoryDAO;

public class ComprarPromocionService {
	
	PromocionDAO promocionDAO = FactoryDAO.getPromocionDAO();
	UsuarioDAO usuarioDAO = FactoryDAO.getUsuarioDAO();
	
	public Map<String, String> comprar(Integer idUsuario, Integer idPromo)  {
		Map<String, String> errores = new HashMap<String, String>();
		
		Usuario usuario = usuarioDAO.findByIdUsuario(idUsuario);
		Promocion promocion = promocionDAO.findByIdPromo(idPromo);
		
		if (!usuario.puedeComprar(promocion)) {
			errores.put("usuario", "No se puede comprar");
		} else if (usuario.puedeComprar(promocion)) {
			usuario.comprarPropuesta(promocion);
			promocion.restarCupo();
			try {
				usuarioDAO.saveItinerario(usuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return errores;
	}
	
}
