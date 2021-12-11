package model;

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

}
