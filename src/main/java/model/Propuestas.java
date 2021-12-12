package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class Propuestas {
	protected Integer idPromocion;
	protected Integer idAtraccion;
	protected String nombrePropuesta;
	protected Integer costo;
	protected Double tiempo;
	protected Integer cupo;
	protected String tipo;
	protected Integer cantAtracciones;
	protected Boolean esPromo;
	protected HashMap<String, String> errors;

	public Propuestas(String nombrePropuesta, Integer costo, Double tiempo, Integer cupo, String tipo) {
		this.nombrePropuesta = nombrePropuesta;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public Propuestas(Integer id, String nombrePropuesta, Integer costo, Double tiempo, Integer cupo, String tipo) {
		this.idAtraccion = id;
		this.nombrePropuesta = nombrePropuesta;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public Propuestas(String nombrePropuesta, String tipo, Integer cantAtracciones) {
		this.nombrePropuesta = nombrePropuesta;
		this.tipo = tipo;
		this.cantAtracciones = cantAtracciones;
	}

	public Propuestas(String nombrePropuesta) {
		this.nombrePropuesta = nombrePropuesta;
	}

	public Propuestas() {

	}

	public Integer getIdAtraccion() {
		return this.idAtraccion;
	}

	public Integer getCosto() {
		return this.costo;
	}

	public Double getTiempo() {
		return this.tiempo;
	}

	public Integer getCupo() {
		return this.cupo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public String getNombre() {
		return this.nombrePropuesta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, nombrePropuesta, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propuestas other = (Propuestas) obj;
		return costo == other.costo && Objects.equals(nombrePropuesta, other.nombrePropuesta)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo) && tipo == other.tipo;
	}

	public Integer restarCupo() {
		if (this.cupo > 0) {
			this.cupo = getCupo();
			this.cupo--;
			System.out
					.println("El cupo disponible para esta atracci�n es de " + cupo + "\n ------------------------");
		}
		return this.cupo;

	}

	public Boolean getEsPromo() {
		return this.esPromo;
	}

	protected abstract Boolean esOContiene(Propuestas propuesta);

	public Integer getIdPromocion() {
		return this.idPromocion;
	}

	public ArrayList<Propuestas> getPromoList() {
		return null;
	}

}