package Ventanas;

import Datos.Producto;
import Datos.ProductoPorCantidad;
import Datos.ProductoPorPeso;
import Datos.Supermercado;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class VentanaTicket extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlNorte, pnlCentro, pnlSur;
	private JLabel lblTitulo;
	private Font f;
	private JTextArea txtTicket;
	private JButton btnCargarFichero, btnSalir, btnOtroPedido;
	private JScrollPane scrollTicket;
	private double suma = 0;
	
	public VentanaTicket() {
		setSize(600, 600);
		getContentPane().setBackground(Color.PINK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblTitulo = new JLabel("Resumen de Compra");
		f = new Font("American Typewriter", Font.BOLD, 40);
		lblTitulo.setFont(f);
		pnlNorte = new JPanel();
		pnlNorte.setBackground(Color.PINK);
		pnlNorte.add(lblTitulo);
		getContentPane().add(pnlNorte, BorderLayout.NORTH);
		
		pnlCentro = new JPanel();
		pnlCentro.setBackground(Color.PINK);
		txtTicket = new JTextArea();
		
		for(Producto p: Supermercado.gettmTicket().keySet()) {
			int iValor = (int)Math.round(Supermercado.gettmTicket().get(p));
			double dValor = Supermercado.gettmTicket().get(p);
			txtTicket.append("------------\n");
			txtTicket.append("Producto seleccionado: " + p.getNombre());
			if(p instanceof ProductoPorCantidad) {
				ProductoPorCantidad pp = (ProductoPorCantidad)p;
				txtTicket.append(" (" + pp.getPrecioUd() + "€/ud)\n");
				txtTicket.append("     Unidades: " + iValor + " uds.\n");
				txtTicket.append("     Precio: " + pp.calcPrecio(iValor) + "€\n");
				suma += pp.calcPrecio(iValor);
			}else if(p instanceof ProductoPorPeso) {
				ProductoPorPeso pp = (ProductoPorPeso)p;
				txtTicket.append(" (" + pp.getprecioKilo() + "€/kg)\n");
				txtTicket.append("     Kilos: " + dValor + " kg.\n");
				txtTicket.append("     Precio: " + pp.calcPrecio(dValor) + "€\n");
				suma += pp.calcPrecio(dValor);
			}
		}
		
		txtTicket.append("------------\n\n");
		txtTicket.append("Precio total = " + suma + " €");
		txtTicket.setColumns(30);
		txtTicket.setRows(50);
		txtTicket.setEditable(false);
		
		scrollTicket = new JScrollPane(txtTicket);
		scrollTicket.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnlCentro.add(scrollTicket, BorderLayout.CENTER);
		getContentPane().add(pnlCentro, BorderLayout.CENTER);
		
		pnlSur = new JPanel();
		pnlSur.setBackground(Color.PINK);
		pnlSur.setLayout(new FlowLayout());
		
		btnOtroPedido = new JButton("Continuar pedido");
		pnlSur.add(btnOtroPedido);
		btnCargarFichero = new JButton("Guardar ticket");
		pnlSur.add(btnCargarFichero);
		btnSalir = new JButton("Salir");
		pnlSur.add(btnSalir);
		
		getContentPane().add(pnlSur, BorderLayout.SOUTH);
		
		btnOtroPedido.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTienda t = new VentanaTienda();
				t.setVisible(true);
				dispose();
			}
		});
		
		btnCargarFichero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintWriter pw = null;
				try {
					pw = new PrintWriter("Ticket.txt");
					pw.println(txtTicket.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if(pw!=null) {
						pw.flush();
						pw.close();
					}
				}
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
			}
		});
		
	}
}
