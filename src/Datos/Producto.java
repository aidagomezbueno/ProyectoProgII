package Datos;

public abstract class Producto implements Comparable<Producto>, Calculable {
	
	private String nombre, proveedor;
	
	public Producto(String nombre, String proveedor) {
		super();
		this.nombre = nombre;
		this.proveedor = proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	

}
