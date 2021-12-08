package persistance.commons;

import persistance.UsuarioDAO;
import persistance.impl.UsuarioDAOImpl;

public class FactoryDAO {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}

	/*
	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAOImpl();
	}
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
	} */
}
