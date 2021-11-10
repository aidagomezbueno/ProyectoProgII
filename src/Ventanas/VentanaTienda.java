package Ventanas;

import Datos.Producto;
import Datos.ProductoPorPeso;
import Datos.ProductoPorCantidad;
import Datos.Supermercado;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaTienda extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlNorte, pnlCentro, pnlSur, pnlSubcentro, pnlEste, pnlSubEste;
	private JLabel lblNorte, lblSubcentroNorte, lblPrecio;
	private Font f;
	private JButton btnVolverAtras, btnVolverInicio, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnAnadirCesta, btnContinuarCompra;
	private JComboBox<Integer> cbCantidad;
	private JComboBox<Double> cbPeso;
	private ArrayList<Integer> aNumeros;
	private ArrayList<Double> aPesos;
	private ArrayList<Producto> aSeleccion;
	private int contadorItems;
	
	public VentanaTienda() {
		
		setSize(600, 500);
		setBackground(Color.PINK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pnlNorte = new JPanel();
		pnlNorte.setBackground(Color.PINK);
		
		lblNorte = new JLabel("Bienvenido, " + Supermercado.getUsuarioActual().getNick() + ".");
		f = new Font("American Typewriter", Font.BOLD, 40);
		lblNorte.setFont(f);
		
		pnlNorte.add(lblNorte);
		
		getContentPane().add(pnlNorte, BorderLayout.NORTH);
		
		pnlSur = new JPanel();
		pnlSur.setBackground(Color.PINK);
		pnlSur.setLayout(new FlowLayout());
		
		btnVolverAtras = new JButton("Atrás");
		btnVolverInicio = new JButton("Inicio");
		btnAnadirCesta = new JButton("Añadir item a la cesta");
		btnContinuarCompra = new JButton("Continuar");
		
		pnlSur.add(btnVolverAtras);
		pnlSur.add(btnVolverInicio);
		pnlSur.add(btnAnadirCesta);
		pnlSur.add(btnContinuarCompra);
		
		getContentPane().add(pnlSur, BorderLayout.SOUTH);
		
		pnlCentro = new JPanel();
		pnlCentro.setBackground(Color.PINK);
		pnlCentro.setLayout(new BorderLayout());
		
		lblSubcentroNorte = new JLabel("Esta es la oferta de productos de la que disponemos.");
		lblSubcentroNorte.setHorizontalAlignment(JLabel.CENTER);
		lblSubcentroNorte.setVerticalAlignment(JLabel.CENTER);
		
		pnlCentro.add(lblSubcentroNorte, BorderLayout.NORTH);
		
		pnlSubcentro = new JPanel();
		pnlSubcentro.setBackground(Color.PINK);
		pnlSubcentro.setLayout(new GridLayout(4, 2));
		
		btn1 = new JButton(new ImageIcon(getClass().getResource("/Fotos/crema2.jpg")));	//crema solar
		btn2 = new JButton(new ImageIcon(getClass().getResource("/Fotos/magdalenas2.png")));	//magdalenas
		btn3 = new JButton(new ImageIcon(getClass().getResource("/Fotos/kinder2.jpg")));	//kinder
		btn4 = new JButton(new ImageIcon(getClass().getResource("/Fotos/salmon2.jpg")));	//salmon
		btn5 = new JButton(new ImageIcon(getClass().getResource("/Fotos/garbanzos2.jpg")));	//garbanzos
		btn6 = new JButton(new ImageIcon(getClass().getResource("/Fotos/manzana2.jpg")));	//manzana
		btn7 = new JButton(new ImageIcon(getClass().getResource("/Fotos/ojito2.jpg")));	//ojito pescado
		btn8 = new JButton(new ImageIcon(getClass().getResource("/Fotos/carne2.jpg")));	//carne 
		
		pnlSubcentro.add(btn1);
		pnlSubcentro.add(btn2);
		pnlSubcentro.add(btn3);
		pnlSubcentro.add(btn4);
		pnlSubcentro.add(btn5);
		pnlSubcentro.add(btn6);
		pnlSubcentro.add(btn7);
		pnlSubcentro.add(btn8);
		
		pnlCentro.add(pnlSubcentro, BorderLayout.CENTER);
		
		getContentPane().add(pnlCentro, BorderLayout.WEST);
		
		pnlEste = new JPanel();
		pnlEste.setLayout(new BorderLayout());
		pnlEste.setBackground(Color.PINK);
		
		
		lblPrecio = new JLabel("Precio: \n");
		lblPrecio.setSize(20, 1);
		
		cbCantidad = new JComboBox<Integer>();
		
		aNumeros = new ArrayList<>();
		aNumeros.add(1);aNumeros.add(2);aNumeros.add(3);aNumeros.add(4);aNumeros.add(5);aNumeros.add(6);aNumeros.add(7);aNumeros.add(8);aNumeros.add(9);aNumeros.add(10);
		for(Integer i: aNumeros) {
			cbCantidad.addItem(i);
		}
		
		cbPeso = new JComboBox<Double>();
		
		aPesos = new ArrayList<>();
		aPesos.add(0.050);aPesos.add(0.100);aPesos.add(0.150);aPesos.add(0.200);aPesos.add(0.250);aPesos.add(0.300);aPesos.add(0.350);
		aPesos.add(0.400);aPesos.add(0.450);aPesos.add(0.500);aPesos.add(0.550);aPesos.add(0.600);aPesos.add(0.650);aPesos.add(0.700);
		aPesos.add(0.750);aPesos.add(0.800);aPesos.add(0.850);aPesos.add(0.900);aPesos.add(0.950);aPesos.add(1.000);
		
		for(Double d: aPesos)
			cbPeso.addItem(d);
		
		aSeleccion = new ArrayList<>();
		
		pnlSubEste = new JPanel();
		pnlSubEste.setLayout(new GridLayout(3, 1));
		pnlSubEste.setBackground(Color.PINK);
		
		pnlSubEste.add(lblPrecio);
		pnlSubEste.add(cbCantidad);
		pnlSubEste.add(cbPeso);
		
		pnlEste.add(pnlSubEste, BorderLayout.WEST);
		
		getContentPane().add(pnlEste, BorderLayout.CENTER);
		
		contadorItems = 0;
		
		btnContinuarCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTicket t = new VentanaTicket();
				t.setVisible(true);
				dispose();
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Crema Solar") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
					
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Magdalena") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
				
			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Kinder Bueno") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
				
			}
		});
		
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Salmón") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
			}
		});
		
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Garbanzo") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
			}
		});
		
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Manzana") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
			}
		});
		
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Ojito") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
			}
		});
		
		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p2;
				cbCantidad.setSelectedIndex(0);
				cbPeso.setSelectedIndex(0);
				for(Producto p: Supermercado.getListaProductos()) {
					if(p.getNombre() == "Carne de Cerdo") {
						p2 = p;
						if(!aSeleccion.contains(p2)) {
							aSeleccion.add(p2);
							contadorItems++;
						}
						if(p2 instanceof ProductoPorCantidad) {
							ProductoPorCantidad p3 = (ProductoPorCantidad)p2;
							lblPrecio.setText("Precio: \n"+p3.getPrecioUd()+" €/ud.");
							cbPeso.setVisible(false);
							cbCantidad.setVisible(true);
						}
						if(p2 instanceof ProductoPorPeso){
							ProductoPorPeso p3 = (ProductoPorPeso)p2;
							lblPrecio.setText("Precio: \n"+p3.getprecioKilo()+" €/kg.");
							cbPeso.setVisible(true);
							cbCantidad.setVisible(false);
						}
					}
				}
			}
		});
		
		btnVolverAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaOpciones vpa = new VentanaOpciones();
				vpa.setVisible(true);dispose();
			}
		});
		
		btnVolverInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio vi = new VentanaInicio();
				vi.setVisible(true);
				dispose();
			}
		});
		
		btnAnadirCesta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto p = aSeleccion.get(aSeleccion.size()-1);
				if(p instanceof ProductoPorCantidad) {
					int cantidad = (int) cbCantidad.getSelectedItem();
					ProductoPorCantidad p1 = (ProductoPorCantidad)p;
					double precio = p1.calcPrecio(cantidad);
					System.out.println("\n\nProducto seleccionado: "+p1.getNombre()+" (" + p1.getPrecioUd() + "€/ud)\n    Unidades: "+ cantidad +"\n    Precio total: " + precio + " €");
					double cant = Double.valueOf(cantidad);
					Supermercado.anadirProductoTicket(p1, cant);
					System.out.println("******Pedido añadido a Ticket");
				}else if(p instanceof ProductoPorPeso) {
					double peso = (double)cbPeso.getSelectedItem();
					ProductoPorPeso p1 = (ProductoPorPeso)p;
					double precio = p1.calcPrecio(peso);
					System.out.println("\n\nProducto seleccionado: " + p1.getNombre() +" (" + p1.getprecioKilo() + "€/kg)\n    Kilos: " + peso + "\n    Precio total: " + precio + " €");
					Supermercado.anadirProductoTicket(p1, peso);
					System.out.println("******Pedido añadido a Ticket");
				}
			}
		});
		
		
	}
	
}
