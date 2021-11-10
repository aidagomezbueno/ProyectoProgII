package Datos;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Supermercado {
	
	private static ArrayList<Usuario> listaUsuarios;
	private static ArrayList<Producto> listaProductos;
	private static Usuario usuarioActual;
	private static TreeMap<Producto, Double> tmTicket;

	public Supermercado() {
		listaUsuarios = new ArrayList<>();
		listaProductos = new ArrayList<>();
		tmTicket = new TreeMap<>();
		usuarioActual = new Usuario();
	}
	
	public static Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public static void setUsuarioActual(Usuario usuarioActual) {
		Supermercado.usuarioActual = usuarioActual;
	}
	
	public static void anadirProductoTicket(Producto p, double cantidad) {
		int cant = 0;
		double peso = 0;
		if(!Supermercado.tmTicket.containsKey(p)) {
			Supermercado.tmTicket.put(p, cantidad);
		}else if(Supermercado.tmTicket.containsKey(p) && p instanceof ProductoPorCantidad){
			cant = (int)Math.round(Supermercado.tmTicket.get(p));
			Supermercado.tmTicket.remove(p);
			cant += cantidad;
			tmTicket.put(p, (double)cant);
		}else if(Supermercado.tmTicket.containsKey(p) && p instanceof ProductoPorPeso) {
			peso = Supermercado.tmTicket.get(p);
			Supermercado.tmTicket.remove(p);
			peso += cantidad;
			tmTicket.put(p, peso);
		}
	}
	public static TreeMap<Producto, Double> gettmTicket() {
		return tmTicket;
	}

	public static void settmTicket(TreeMap<Producto, Double> tmTicket) {
		Supermercado.tmTicket = tmTicket;
	}

	public static ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public static void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		Supermercado.listaUsuarios = listaUsuarios;
	}


	public static void setListaProductos(ArrayList<Producto> listaProductos) {
		Supermercado.listaProductos = listaProductos;
	}

	public static void anyadirProducto(Producto p) {
		listaProductos.add(p);
	}

	public static ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

//	public static ArrayList<Usuario> leerFicheroUsuarios() {	//lee el fichero y añade los usuarios a la lista
//		ObjectInputStream ois = null;
//		try {
//			ois = new ObjectInputStream(new FileInputStream("Usuarios.dat"));
//			Usuario u = (Usuario) ois.readObject(); 
//			listaUsuarios.add(u);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if (ois != null) {
//				try {
//					ois.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return listaUsuarios;
//	}
	
	public static boolean anyadirUsuarioLista(Usuario u) {	//si no existe el usuario en la lista, lo añade
		boolean anadir = false;
		if(!existeUsuario(u)) {
			listaUsuarios.add(u);
			System.out.println("Usuario añadido a la lista.");
			JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
			System.out.println(listaUsuarios);
			anadir = true;
		}else {
//			System.out.println("No se ha podido crear el usuario.");
			System.out.println("Ya existe el usuario en la lista.");
			JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nick.\nEscoga otro, por favor.");
		}
		return anadir;
	}
	
	public static boolean existeUsuario(Usuario u) {	//devuelve true si existe el usuario en la lista, false si no.
		boolean enc = false;
		for(Usuario ur: listaUsuarios) {
			if((ur.getNick()).equals(u.getNick())) {
				enc = true;
			}
		}
		return enc;
	}
	
	public static boolean existeUsuario(String n) {	//devuelve true si existe el nick en la lista, false si no.
		boolean enc = false;
		for(Usuario ur: listaUsuarios) {
			if((ur.getNick()).equals(n)) {
				System.out.println("Existe el usuario en la lista.");
				enc = true;
			}
		}
		return enc;
	}
	
//	public static void escribirFicheroUsuarios() {	//carga el fichero con los usuarios de la lista
//		ObjectOutputStream oos = null;
//		try {
//			oos = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"));
//			for(Usuario u: listaUsuarios) {
////				if(!buscarUsuario(u)) {
//					oos.writeObject(u);
////				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if(oos != null) {
//				try {
//					oos.close();
//					oos.flush();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
//	public static ArrayList<Producto> leerFicheroProductos() {	//lee el fichero y añade los productos a la lista
//		ObjectInputStream ois = null;
//		try {
//			ois = new ObjectInputStream(new FileInputStream("Productos.dat"));
//			Producto p = (Producto) ois.readObject();
//			listaProductos.add(p);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			if (ois != null) {
//				try {
//					ois.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return listaProductos;
//	}
	
	
	
	public static void anyadirProductoLista(Producto p) {
		for(Producto pr: listaProductos) {
			if(pr.equals(p)) {
				System.out.println("No se puede añadir este artículo. Producto ya existente.");
			}else {
				listaProductos.add(p);
				System.out.println("Producto añadido a la lista.");
			}
		}
	}


	
//	public static void escribirFicheroProductos() {	//por cada producto que haya en listaProductos, se escribe en el fichero.
//		ObjectOutputStream oos = null;
//		try {
//			oos = new ObjectOutputStream(new FileOutputStream("Productos.dat"));
//			for(Producto p: listaProductos) {
////				if(!buscarProductoLista(p)) {
////					oos.writeObject(p);
////				}
//				oos.writeObject(p);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if(oos != null) {
//				try {
//					oos.close();
//					oos.flush();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	
	
	
	
	
}
