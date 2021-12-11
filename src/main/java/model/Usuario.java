package model;

import java.util.*;

import utils.Crypt;

public class Usuario {

	protected Integer idUsuario;
	protected String nombre;
	protected String password;
	protected Boolean admin;
	protected String atraccionFavorita;
	protected Integer presupuesto;
	protected Double tiempoDisponible;
	protected Boolean active;
	protected ArrayList<Propuestas> itinerarioUsuario;
	private HashMap<String, String> errors;
	

	public Usuario(Integer idUsuario, String nombre, String password, Boolean admin, String atraccionFavorita, Integer presupuesto, 
			Double tiempoDisponible, Boolean active) {
		
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.admin = admin;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.active = active;
		
		this.itinerarioUsuario = new ArrayList<Propuestas>();
	}
	
	public Usuario(Integer idUsuario, String nombre, String password, Integer admin1, String atraccionFavorita, Integer presupuesto, 
			Double tiempoDisponible, Integer active1) {
		setAdmin(admin1);
		setActive(active1);
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password = password;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		
		this.itinerarioUsuario = new ArrayList<Propuestas>();
	}
	
	public Usuario(String nombre, String password, Boolean admin, String atraccionFavorita, Integer presupuesto, Double tiempoDisponible) {
		this.nombre = nombre;
		this.password = password;
		this.admin = admin;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		
		this.itinerarioUsuario = new ArrayList<Propuestas>();
	}
	
	public Usuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario(String nombre, String password, String atraccionFavorita, Integer presupuesto, Double tiempoDisponible) {
		this.nombre = nombre;
		this.password = password;
		this.atraccionFavorita = atraccionFavorita;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer id) {
		this.idUsuario = id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getPresupuesto() {
		return this.presupuesto;
	}

	public Double getTiempo() {
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
	
	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}
	
	public String getPassword() {
		return password;
	}
	
	public Boolean getAdmin() {
		return admin;
	}
	
	public void setAdmin(Integer admin1) {
		if(admin1 == 1)
			this.admin = true;
	}
	
	public Boolean isAdmin() {
		return admin;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Integer active1) {
		if(active1 == 1)
			this.active = true;
	}
	
	public Boolean isActive() {
		return active;
	}


	public void setItinerarioUsuario(ArrayList<Propuestas> itinerarioUsuario) {
		this.itinerarioUsuario = itinerarioUsuario;
	}
	
	public ArrayList<Propuestas> getItinerarioUsuario() {
		return this.itinerarioUsuario;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto < 0) {
			errors.put("coins", "No debe ser negativo");
		}
		if (tiempoDisponible < 0) {
			errors.put("time", "No debe ser negativo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	@Override
	public String toString() {
		return "id_usuario: " + idUsuario + " | Nombre: " + nombre +
			   " | Password: " + password + " | Admin: " + admin +
			   " | Atraccion Favorita: " + atraccionFavorita + " | Presupuesto: " + presupuesto +
			   " | Tiempo Disponible: " + tiempoDisponible;
	}
}
