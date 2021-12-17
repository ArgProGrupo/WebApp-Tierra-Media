package model;

import java.util.HashMap;

import persistence.impl.AtraccionDAOImpl;

public class Atraccion extends Propuestas {
	private int idAtraccion;

	public Atraccion(Integer idAtraccion, String nombrePropuesta, Integer costo, Double tiempo, Integer cupo, String tipo) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.idAtraccion = idAtraccion;
		this.esPromo = false;
	}

	public Atraccion(String nombrePropuesta, Integer costo, Double tiempo, Integer cupo, String tipo) {
		super(nombrePropuesta, costo, tiempo, cupo, tipo);
		this.esPromo = false;
	}

	public Atraccion(Integer idAtraccion) {
		super();
		this.idAtraccion = idAtraccion;
		this.esPromo = false;
	}

	public Atraccion(AtraccionDAOImpl findByIdAtraccion) {
	}

	public String getTipo() {
		return this.tipo;
	}

	public Integer getIdAtraccion() {
		return this.idAtraccion;
	}

	@Override
	public String toString() {
		return "Id: " + idAtraccion + " | Nombre: " + nombrePropuesta + " | Costo: " + costo + " | Tiempo: " + tiempo
				+ " | Cupo: " + getCupo() + " | Tipo De Atraccion: " + tipo + "\n";
	}

	@Override
	protected Boolean esOContiene(Propuestas propuesta) {
		return (this.equals(propuesta));
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (costo < 0) {
			errors.put("costo", "No debe ser negativo");
		}
		if (tiempo < 0) {
			errors.put("duracion", "No debe ser negativo");
		}
		if (cupo < 0) {
			errors.put("cupo", "No debe ser negativo");
		}
	}
	
	public String getNombre() {
		return super.getNombre();
	}
	
	public Integer getCosto() {
		return super.getCosto();
	}
	
	public Double getTiempo() {
		return super.getTiempo();
	}
	
	public Integer getCupo() {
		return super.getCupo();
	}

}
