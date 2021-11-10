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

import Datos.Supermercado;



public class VentanaInicio extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel panelCentro, panelSur, panelNorte;
	private JLabel lblBienvenida, lblFoto;
	private JButton btnIniciarSesion, btnRegistrarse, btnUsuario;
	ImageIcon imagenFoto;
	
	public VentanaInicio() {
		//PROPIEDADES VENTANA
		setSize(600, 500);
		getContentPane().setBackground(Color.PINK);
//		getContentPane().setLayout(new GridLayout(3, 1));
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		//PANELES VENTANA
		//PANEL NORTE
		panelNorte = new JPanel();
		panelNorte.setBackground(Color.PINK);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		
		lblBienvenida = new JLabel("SUPERMERCADO EXPRÉS");
		Font f = new Font("American Typewriter", Font.BOLD, 40);
		lblBienvenida.setFont(f);
		panelNorte.add(lblBienvenida);
		
		
		//PANEL CENTRO
		panelCentro = new JPanel();
		panelCentro.setBackground(Color.PINK);
		panelCentro.setLayout(new FlowLayout());
		lblFoto = new JLabel();
		lblFoto.setIcon(new ImageIcon(getClass().getResource("/Fotos/inicio.png")));
		lblFoto.setHorizontalAlignment(JLabel.CENTER);
		lblFoto.setVerticalAlignment(JLabel.CENTER);
		panelCentro.add(lblFoto, BorderLayout.CENTER);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		//PANEL SUR
		panelSur = new JPanel();
		panelSur.setBackground(Color.PINK);
//		panelSur.setLayout(new GridLayout(1, 1));
		panelSur.setLayout(new FlowLayout());
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnRegistrarse = new JButton("Registrarse");
		String usu = Supermercado.getUsuarioActual().getNick();
		panelSur.add(btnIniciarSesion);
		panelSur.add(btnRegistrarse);
		if(Supermercado.getUsuarioActual().getNick()!=null) {
			btnUsuario = new JButton("Entrar como " + usu);
			panelSur.add(btnUsuario);
			btnUsuario.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaOpciones vo = new VentanaOpciones();
					vo.setVisible(true);
					dispose();
				}
			});
		}
		
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion is = new VentanaInicioSesion();
				is.setVisible(true);
				dispose();
			}
		});
		
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro r = new VentanaRegistro();
				r.setVisible(true);
				dispose();
			}
		});

	}
	
}
