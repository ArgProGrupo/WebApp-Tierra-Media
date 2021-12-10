package nullobjects;

import model.Usuario;

public class NullUsuario extends Usuario {
	
	public NullUsuario() {
		super(0, "", " ", 0, " ", 0, 0.0, 0);
	}
	
	public static Usuario build() {
		return new NullUsuario();
	}
	
	public boolean isNull() {
		return true;
	}

}
