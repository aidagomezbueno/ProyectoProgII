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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import Datos.Supermercado;
import Datos.Usuario;

public class VentanaRegistro extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel pnlNorte, pnlSur, pnlCentro;
	private JLabel lblNorte, lblNick, lblPw, lblFoto;
	private JButton btnVolver, btnRegistrar;
	private JTextArea txtNick;
	private JPasswordField txtPw;

	VentanaRegistro(){
		setSize(600, 500);
		setBackground(Color.PINK);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		lblNorte = new JLabel("Registro de Usuarios");
		lblNorte.setBackground(Color.PINK);
		Font f = new Font("American Typewriter", Font.BOLD, 40);
		lblNorte.setFont(f);
		pnlNorte = new JPanel();
		pnlNorte.setBackground(Color.PINK);
		pnlNorte.add(lblNorte);
		getContentPane().add(pnlNorte, BorderLayout.NORTH);
		
		btnVolver = new JButton("Volver al Inicio");
		btnRegistrar = new JButton("Registrar");
		pnlSur = new JPanel();
		pnlSur.setLayout(new FlowLayout());
		pnlSur.setBackground(Color.PINK);
		pnlSur.add(btnVolver);
		pnlSur.add(btnRegistrar);
		getContentPane().add(pnlSur, BorderLayout.SOUTH);
		
		pnlCentro = new JPanel();
		pnlCentro.setLayout(new FlowLayout());
		pnlCentro.setBackground(Color.PINK);
		lblNick = new JLabel("Introduzca su nuevo nick: ");
		txtNick = new JTextArea();
		txtNick.setColumns(30);
		lblPw = new JLabel("Introduzca su nueva contraseña: ");
		txtPw = new JPasswordField();
		txtPw.setColumns(30);
		lblFoto = new JLabel();
		lblFoto.setIcon(new ImageIcon(getClass().getResource("/Fotos/inicio.png")));
		lblFoto.setHorizontalAlignment(JLabel.CENTER);
		lblFoto.setVerticalAlignment(JLabel.CENTER);
		pnlCentro.add(lblNick);
		pnlCentro.add(txtNick);
		pnlCentro.add(lblPw);
		pnlCentro.add(txtPw);
		pnlCentro.add(lblFoto);
		getContentPane().add(pnlCentro, BorderLayout.CENTER);
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio v = new VentanaInicio();
				v.setVisible(true);
				dispose();
			}
		});
		
		btnRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nick = txtNick.getText();
				String password = txtPw.getText();
				Usuario u = new Usuario(nick, password);
//				s = new Supermercado();
//				if(!s.buscarUsuarioLista(u)) {
//					s.anyadirUsuarioLista(u);
//					System.out.println("Usuario registrado correctamente.");
//					System.out.println(s.getListaClientes());
//					JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");
//				}else {
//					System.out.println("Este usuario ya existe. Introduzca otras credenciales.");
//					JOptionPane.showMessageDialog(null, "Este usuario ya existe. Introduzca otras credenciales.");
//				}
				if(Supermercado.anyadirUsuarioLista(u)) {
					VentanaInicioSesion vis = new VentanaInicioSesion();
					vis.setVisible(true);
					dispose();
				}
				txtNick.setText("");
				txtPw.setText("");
//				System.out.println("Usuario registrado.");
//				System.out.println(s.getListaClientes());
					
					
			}
		});
		
		
		
		
		
		
		
	}
	
}
