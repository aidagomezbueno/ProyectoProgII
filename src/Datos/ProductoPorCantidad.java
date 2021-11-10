package Datos;

import java.util.ArrayList;

public class ProductoPorCantidad extends Producto {
	
	private double precioUd;
	private eCantidad tipo;
	private ArrayList<String> ingredientes;
	private int cantidad;

	
	public ProductoPorCantidad(String nombre, String proveedor, ArrayList<String> ingredientes) {
		super(nombre, proveedor);
	}
	
	public ProductoPorCantidad(String nombre, String proveedor, ArrayList<String> ingredientes, double precioUd, eCantidad tipo) {
		super(nombre, proveedor);
		this.precioUd = precioUd;
		this.tipo = tipo;
		this.ingredientes = ingredientes;
		this.cantidad = 0;
	}

	public double getPrecioUd() {
		return precioUd;
	}
	
	public void setPrecioUd(double precioUd) {
		this.precioUd = precioUd;
	}
	
	
	public eCantidad getTipo() {
		return tipo;
	}
	
	public void setTipo(eCantidad tipo) {
		this.tipo = tipo;
	}
	
	
	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "\n[Producto: " + getNombre() + " -> proveedor: " + getProveedor() + "; ingredientes: " + ingredientes + "; tipo: " + tipo + ";\nprecio/Ud = " + precioUd + "]";
	}
	
	public ProductoPorCantidad castPtoPCant(Producto p) {
		return (ProductoPorCantidad)p;
	}

	@Override
	public int compareTo(Producto o) {
		return this.getNombre().compareTo(o.getNombre());
	}

	@Override
	public double calcPrecio(Object o) {
		int cantidad = (int)o;
		this.cantidad = cantidad;
		return this.precioUd*cantidad;
	}

}
