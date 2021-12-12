package nullobjects;

import model.Atraccion;


public class NullAtraccion extends Atraccion {
	
	public NullAtraccion() {
		super("", 0,0.0, 0 ," ");
	}
	
	public static Atraccion build() {
		return new NullAtraccion();
	}
	
	public boolean isNull() {
		return true;
	}

}
