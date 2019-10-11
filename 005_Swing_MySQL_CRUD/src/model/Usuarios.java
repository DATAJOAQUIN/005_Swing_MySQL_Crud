package model;

public class Usuarios {

	private int id;
	private String nombre, password, estado;
	
	public Usuarios(int codigo, String n, String p, String e) {
		this.id=codigo;
		this.nombre=n;
		this.password=p;
		this.estado=e;
		
	}//cierra constructor

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String getEstado() {
		return estado;
	}
	
	
}//cierra la clase
