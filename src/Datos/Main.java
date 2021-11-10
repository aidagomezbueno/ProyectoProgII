package Datos;

import java.util.ArrayList;

import Ventanas.VentanaInicio;

public class Main {
	
	public static void main(String[] args) {
		Supermercado s = new Supermercado();
		s.anyadirUsuarioLista(new Usuario("admin", "admin"));
//		Clientes c = new Clientes();
		
//		ArrayList<Producto> aProductos;
		ArrayList<String> aIngredientesCrema, aIngredientesMagdalena, aIngredientesKinder, aIngredientesSalmon, aIngredientesGarbanzo;
		
//		String [] aIngredientesCrema = {"Aqua", "Aloe Barbadensis leaf extract", "Olea europaea fruit extract", "Zinc Oxide", "Triticum Vulgare germ oil"};
//		String [] aIngredientesMagdalena = {"Harinas", "Malitol", "Aceite de Soja", "Huevo", "Agua"};
//		String [] aIngredientesKinder = {"Chocolate", "Leche", "Mantequilla", "Vainilla", "Avellanas"};
//		String [] aIngredientesSalmon = {"Salmón"};
//		String [] aIngredientesGarbanzo = {"Garbanzo"};
		
		aIngredientesCrema = new ArrayList<>();
		aIngredientesMagdalena = new ArrayList<>();
		aIngredientesKinder = new ArrayList<>();
		aIngredientesSalmon = new ArrayList<>();
		aIngredientesGarbanzo = new ArrayList<>();
		
		aIngredientesCrema.add("Aqua");
		aIngredientesCrema.add("Aloe Barbadensis leaf extract");
		aIngredientesCrema.add("Olea europaea fruit extract");
		aIngredientesCrema.add("Zinc Oxide");
		aIngredientesCrema.add("Triticum Vulgare germ oil");
		
		aIngredientesMagdalena.add("Harinas");
		aIngredientesMagdalena.add("Malitol");
		aIngredientesMagdalena.add("Aceite de Soja");
		aIngredientesMagdalena.add("Huevo");
		aIngredientesMagdalena.add("Agua");
		
		aIngredientesKinder.add("Chocolate");
		aIngredientesKinder.add("Leche");
		aIngredientesKinder.add("Mantequilla");
		aIngredientesKinder.add("Vainilla");
		aIngredientesKinder.add("Avellanas");
		
		aIngredientesSalmon.add("Salmón");
		
		aIngredientesGarbanzo.add("Garbanzo");
		
		//DECLARACIÓN DE OBJETOS/PRODUCTOS
		ProductoPorCantidad p1, p2, p3, p4, p5;
		ProductoPorPeso p6, p7, p8;
		
		//INICIALIZACIÓN/CREACIÓN DE OBJETOS/PRODUCTOS 
		p1 = new ProductoPorCantidad("Crema Solar", "Cocunat", aIngredientesCrema, 23.95, eCantidad.PARAFARMACIA);
		p2 = new ProductoPorCantidad("Magdalena", "La Bella EASO", aIngredientesMagdalena, 1.99, eCantidad.PASTELERIA);
		p3 = new ProductoPorCantidad("Kinder Bueno", "Ferrero Ibérica", aIngredientesKinder, 3.99, eCantidad.PASTELERIA);
		p4 = new ProductoPorCantidad("Salmón", "PESCANOVA", aIngredientesSalmon, 7.80, eCantidad.CONGELADO);
		p5 = new ProductoPorCantidad("Garbanzo", "LUENGO", aIngredientesGarbanzo, 3.15, eCantidad.LEGUMBRE);
		
		p6 = new ProductoPorPeso("Manzana", "Pink Lady", 3.69, ePeso.FRUTERIA);
		p7 = new ProductoPorPeso("Ojito", "La Sirena", 3.13, ePeso.PESCADERIA);
		p8 = new ProductoPorPeso("Carne de Cerdo", "Carnes Chelo&Muñico", 1.28, ePeso.CARNICERIA);
		
		
		Supermercado.anyadirProducto(p1);
		Supermercado.anyadirProducto(p2);
		Supermercado.anyadirProducto(p3);
		Supermercado.anyadirProducto(p4);
		Supermercado.anyadirProducto(p5);
		Supermercado.anyadirProducto(p6);
		Supermercado.anyadirProducto(p7);
		Supermercado.anyadirProducto(p8);
		
//		aProductos = new ArrayList<>();
//		aProductos.add(p1);
//		aProductos.add(p2);
//		aProductos.add(p3);
//		aProductos.add(p4);
//		aProductos.add(p5);
//		aProductos.add(p6);
//		aProductos.add(p7);
//		aProductos.add(p8);
		
		VentanaInicio v = new VentanaInicio();
		v.setVisible(true);
		
		
		
	}
	
//	public void cargarFicheroProductos() {
//		ObjectOutputStream oos = null;
//		
//		try {
//			oos = new ObjectOutputStream(new FileOutputStream("Productos.dat"));
//			for(Producto p: )
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
