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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import Datos.Supermercado;
import Datos.Usuario;

public class VentanaInicioSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JPanel panelNorte, panelCentro, panelSur, panelNick, panelPW;
	private JButton btnConfirmar, btnVolver;
	private JLabel lblInicio, lblNick, lblPassword, lblFoto;
	private JTextArea txtNick;
	private JPasswordField txtPw;
	private String nick, pw;
	private FlowLayout layoutInicio;
	
	
	
	public VentanaInicioSesion() {
		//PROPIEDADES VENTANA
		setSize(600, 500);
		getContentPane().setBackground(Color.PINK);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		panelNorte = new JPanel();
		panelNorte.setBackground(Color.PINK);
		lblInicio = new JLabel("Inicio Sesión");
		lblInicio.setBackground(Color.PINK);
		Font f = new Font("American Typewriter", Font.BOLD, 40);
		lblInicio.setFont(f);
		panelNorte.add(lblInicio);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		
		panelCentro = new JPanel();
//		panelCentro.setLayout(new GridLayout(2, 1));
		panelCentro.setBackground(Color.PINK);
		layoutInicio = new FlowLayout(FlowLayout.CENTER);
		panelCentro.setLayout(layoutInicio);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		panelNick = new JPanel();
		panelNick.setBackground(Color.PINK);
		panelNick.setLayout(new FlowLayout());
		panelPW = new JPanel();
		panelPW.setBackground(Color.PINK);
		panelPW.setLayout(new FlowLayout());
		lblNick = new JLabel("Introduzca su usuario: ");
//		lblNick.setAlignmentX(CENTER_ALIGNMENT);
//		lblNick.setAlignmentY(CENTER_ALIGNMENT);
		txtNick = new JTextArea();
		txtNick.setColumns(30);
//		txtNick.setRows(2);
//		txtNick.setAlignmentX(CENTER_ALIGNMENT);
//		txtNick.setAlignmentY(CENTER_ALIGNMENT);
		lblPassword = new JLabel("Introduzca su contraseña: ");
//		lblPassword.setAlignmentX(CENTER_ALIGNMENT);
//		lblPassword.setAlignmentY(CENTER_ALIGNMENT);
		txtPw = new JPasswordField();
		txtPw.setColumns(30);
//		txtPw.setAlignmentX(CENTER_ALIGNMENT);
//		txtPw.setAlignmentY(CENTER_ALIGNMENT);
		panelNick.add(lblNick);
		panelNick.add(txtNick);
		panelPW.add(lblPassword);
		panelPW.add(txtPw);
//		panelNick.setAlignmentX(CENTER_ALIGNMENT);
//		panelNick.setAlignmentY(CENTER_ALIGNMENT);
//		panelPW.setAlignmentX(CENTER_ALIGNMENT);
//		panelPW.setAlignmentY(CENTER_ALIGNMENT);
		panelCentro.add(panelNick);
		panelCentro.add(panelPW);
		
		lblFoto = new JLabel();
		lblFoto.setIcon(new ImageIcon(getClass().getResource("/Fotos/inicio.png")));
		lblFoto.setHorizontalAlignment(JLabel.CENTER);
		lblFoto.setVerticalAlignment(JLabel.CENTER);
		panelCentro.add(lblFoto);
		
		panelSur = new JPanel();
		panelSur.setLayout(new FlowLayout());
		panelSur.setBackground(Color.PINK);
		btnConfirmar = new JButton("Confirmar");
		btnVolver = new JButton("Volver");
		panelSur.add(btnVolver);
		panelSur.add(btnConfirmar);
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio v = new VentanaInicio();
				v.setVisible(true);
				dispose();
			}
		});
		
//		btnConfirmar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				nick = txtNick.getText();
//				pw = txtPw.getText();
//				Usuario u = new Usuario(nick, pw);
////				s = new Supermercado();
//				//COMPROBAMOS SI LAS CREDENCIALES SON CORRECTAS.
//				if(Supermercado.existeUsuario(u)) {
//					System.out.println("Acceso a cliente permitido.");
//					JOptionPane.showMessageDialog(null, "Credenciales correctas. Acceso permitido a usuario: " + u.getNick() + ".");
//					Tienda t = new Tienda();
//					t.setVisible(true);
//					dispose();
//				}else {	//SI SON INCORRECTAS SE RESETEA LA VENTANA.
//					System.out.println("Acceso a cliente denegado.");
//					JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Acceso denegado. Vuelva a intentarlo.");
//					txtNick.setText("");
//					txtPw.setText("");
//				}
//			}
//		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nick = txtNick.getText();
				pw = txtPw.getText();
				Usuario u = new Usuario(nick, pw);
				if(Supermercado.existeUsuario(u)) {
					Supermercado.setUsuarioActual(u);
					System.out.println("Acceso a cliente correcto.");
					JOptionPane.showMessageDialog(null, "Acceso a cliente correcto.");
					txtNick.setText("");
					txtPw.setText("");
//					VentanaTienda t = new VentanaTienda();
//					t.setVisible(true);
//					dispose();
					VentanaOpciones va = new VentanaOpciones();
					va.setVisible(true);
					dispose();
				}else {
					System.out.println("Acceso a cliente denegado. Primero, debe registrarse.");
					JOptionPane.showMessageDialog(null, "Acceso a cliente denegado. Primero, debe registrarse.");
					txtNick.setText("");
					txtPw.setText("");
				}
			}
		});
		
	
	}
}
	
