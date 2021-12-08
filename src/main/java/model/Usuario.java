package model;

import java.util.*;

import utils.Crypt;

public class Usuario {

	private Integer idUsuario;
	private String nombre;
	private String password;
	private boolean admin;
	private String atraccionFavorita;
	private Integer presupuesto;
	private Double tiempoDisponible;
	private boolean active;
	public ArrayList<Propuestas> itinerarioUsuario;
	

	public Usuario(Integer idUsuario, String nombre, String password, boolean admin, String atraccionFavorita, Integer presupuesto, 
			Double tiempoDisponible, boolean active) {
		
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.setPassword(password);
		this.admin = admin;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.active = active;
		
		this.itinerarioUsuario = new ArrayList<Propuestas>();
	}
	
	public Usuario(String nombre, String password, boolean admin, String atraccionFavorita, Integer presupuesto, Double tiempoDisponible) {
		this.nombre = nombre;
		this.setPassword(password);
		this.admin = admin;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		
		//this.itinerarioUsuario = new ArrayList<Propuestas>();
	}
	
	public Usuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario(int idUsuario, String nombre, String password, String string3, boolean b, String string4, double double1,
			boolean active2) {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public int setIdUsuario(int id) {
		return this.idUsuario = id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public double getTiempo() {
		return this.tiempoDisponible;
	}

	public String getTipoAtraccionFavorita() {
		return this.atraccionFavorita;
	}

	public String getItinerarioString() {
		String itinerario = "";
		if (itinerario == "") {
			for (Propuestas p : itinerarioUsuario)
				itinerario += p + "\n";
		} else
			itinerario = "";
		return itinerario;

	}

	@Override
	public String toString() {
		return "id_usuario: " + idUsuario + " | Nombre: " + nombre +
			   " | Atraccion Favorita: " + atraccionFavorita + " | Presupuesto: " + presupuesto +
			   " | Tiempo Disponible: " + tiempoDisponible;
	}

	public boolean puedeComprar(Propuestas propuesta) {
		if (this.getPresupuesto() >= propuesta.getCosto() && 
			this.getTiempo() >= propuesta.getTiempo() &&
			propuesta.getCupo() > 0) {
			if (propuesta.esPromo) {
				for (Propuestas p : itinerarioUsuario) {
					if (propuesta.esOContiene(p))
						return false;
				}
			} else {
				if (itinerarioUsuario.contains(propuesta)) {
					return false;
				} else {
					for (Propuestas p : itinerarioUsuario) {
						if (p.esOContiene(propuesta))
							return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	public void comprarPropuesta(Propuestas propuesta) {
		if (puedeComprar(propuesta)) {
			this.presupuesto -= propuesta.getCosto();
			this.tiempoDisponible -= propuesta.getTiempo();
			itinerarioUsuario.add(propuesta);

			System.out.println("Te quedan " + this.presupuesto + " monedas y " + this.tiempoDisponible + " horas");
		}
	}

	public boolean tieneTiempoYDinero() {
		if (this.getPresupuesto() > 0 && this.getTiempo() > 0)
			return true;
		else
			return false;
	}

	public boolean isNull() {
		return false;
	}

	public boolean checkPassword(String password) {
		return Crypt.match(password, this.password);
	}
	
	public void setPassword(String nombre) {
		this.password = Crypt.hash(password);
	}
	
	public boolean isAdmin() {
		return admin;
	}
}
