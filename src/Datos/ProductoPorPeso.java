package Datos;

public class ProductoPorPeso extends Producto {	
	private double precioKilo;
	private ePeso tipo;
	private double peso;	//en kilos (200 gr = 0.2)
	
	
	public ProductoPorPeso(String nombre, String proveedor) {
		super(nombre, proveedor);
	}

	public ProductoPorPeso(String nombre, String proveedor, double precioKilo, ePeso tipo) {
		super(nombre, proveedor);
		this.tipo = tipo;
		this.precioKilo = precioKilo;
		this.peso = 0.0;
	}

	public ePeso getTipo() {
		return tipo;
	}

	public void setTipo(ePeso tipo) {
		this.tipo = tipo;
	}

	
	public double getprecioKilo() {
		return precioKilo;
	}

	public void setprecioKilo(float precioKilo) {
		this.precioKilo = precioKilo;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setprecioKilo(double precioKilo) {
		this.precioKilo = precioKilo;
	}

	@Override
	public String toString() {
		return "\n[Producto: " + getNombre() + " -> proveedor: " + getProveedor() + "; tipo: " + tipo + ";\nprecio/kilo = " + precioKilo + "]";
	}

	public ProductoPorPeso castPtoPPeso(Producto p) {
		return (ProductoPorPeso)p;
	}

	@Override
	public int compareTo(Producto o) {
		return this.getNombre().compareTo(o.getNombre());
	}

	@Override
	public double calcPrecio(Object o) {
		double peso = (double)o;
		this.peso = peso;
		return this.precioKilo*peso;
	}
	
	
}
