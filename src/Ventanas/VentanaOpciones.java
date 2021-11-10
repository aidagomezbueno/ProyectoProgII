package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaOpciones extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTitulo, lblFoto;
	JPanel pnlOpciones;
	JButton btnAjustes, btnIrTienda, btnInicio;
	Font f;
	
	public VentanaOpciones() {
		
		setSize(600, 500);
		getContentPane().setBackground(Color.PINK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		lblTitulo = new JLabel("Opciones");
		f = new Font("American Typewriter", Font.BOLD, 40);
		lblTitulo.setFont(f);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		lblTitulo.setVerticalAlignment(JLabel.CENTER);
		
		pnlOpciones = new JPanel();
		pnlOpciones.setLayout(new FlowLayout());
		pnlOpciones.setBackground(Color.PINK);
		
		btnAjustes = new JButton("Ajustes");
		btnAjustes.setVerticalAlignment(JButton.CENTER);
		btnAjustes.setHorizontalAlignment(JButton.CENTER);
		btnIrTienda = new JButton("Ingresar en la Tienda");
		btnIrTienda.setVerticalAlignment(JButton.CENTER);
		btnIrTienda.setHorizontalAlignment(JButton.CENTER);
		btnInicio = new JButton("Inicio");
		
		pnlOpciones.add(btnAjustes);
		pnlOpciones.add(btnIrTienda);
		pnlOpciones.add(btnInicio);
		getContentPane().add(pnlOpciones, BorderLayout.CENTER);
		
		lblFoto = new JLabel();
		lblFoto.setIcon(new ImageIcon(getClass().getResource("/Fotos/inicio.png")));
		lblFoto.setHorizontalAlignment(JLabel.CENTER);
		lblFoto.setVerticalAlignment(JLabel.CENTER);
		getContentPane().add(lblFoto, BorderLayout.SOUTH);
		
		btnIrTienda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTienda vt = new VentanaTienda();
				vt.setVisible(true);
				dispose();
			}
		});
		
		btnAjustes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAjustes va = new VentanaAjustes();
				va.setVisible(true);
				dispose();
			}
		});
		
		btnInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio vi = new VentanaInicio();
				vi.setVisible(true);
				dispose();
			}
		});
		
		
		
	}

}
