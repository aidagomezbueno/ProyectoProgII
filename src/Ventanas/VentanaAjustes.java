package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Datos.Supermercado;
import Datos.Usuario;

public class VentanaAjustes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnl, pnlNorte;
	private JButton btnCambiarNombre, btnCambiarContraseña, btnAtras;
	private JLabel lblTitulo, lblFoto, lblNick, lblPW;
	private JTextField txtNick;
	private JPasswordField txtPw;
	private Font f, f2;

	public VentanaAjustes() {

		setSize(600, 500);
		getContentPane().setBackground(Color.PINK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pnlNorte = new JPanel();
		pnlNorte.setLayout(new GridLayout(3, 1));
		pnlNorte.setBackground(Color.PINK);

		lblTitulo = new JLabel("Ajustes");
		f = new Font("American Typewriter", Font.BOLD, 40);
		lblTitulo.setFont(f);
		lblTitulo.setVerticalAlignment(JLabel.CENTER);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		
		lblNick = new JLabel("*Su nick actual es " + Supermercado.getUsuarioActual().getNick());
		f2 = new Font("Helvetica", Font.ITALIC, 10);
		lblNick.setFont(f2);
		lblNick.setVerticalAlignment(JLabel.CENTER);
		lblNick.setHorizontalAlignment(JLabel.CENTER);
		
		lblPW = new JLabel("");
		lblPW.setFont(f2);
		lblPW.setVerticalAlignment(JLabel.CENTER);
		lblPW.setHorizontalAlignment(JLabel.CENTER);

		pnlNorte.add(lblTitulo);
		pnlNorte.add(lblNick);
		pnlNorte.add(lblPW);
		
		getContentPane().add(pnlNorte, BorderLayout.NORTH);

		lblFoto = new JLabel();
		lblFoto.setIcon(new ImageIcon(getClass().getResource("/Fotos/inicio.png")));
		lblFoto.setHorizontalAlignment(JLabel.CENTER);
		lblFoto.setVerticalAlignment(JLabel.CENTER);
		getContentPane().add(lblFoto, BorderLayout.SOUTH);

		btnCambiarNombre = new JButton("Cambiar mi nombre/nick de usuario");
		btnCambiarContraseña = new JButton("Cambiar mi contraseña                    ");
		txtNick = new JTextField();
		txtNick.setColumns(20);
		txtNick.setHorizontalAlignment(JTextField.CENTER);
		txtPw = new JPasswordField();
		txtPw.setColumns(20);
		txtPw.setHorizontalAlignment(JTextField.CENTER);
		
		pnl = new JPanel();
		pnl.setLayout(new FlowLayout());
		pnl.setBackground(Color.PINK);
		
		btnAtras = new JButton("Atrás");

		pnl.add(txtNick);
		pnl.add(btnCambiarNombre);
		pnl.add(txtPw);
		pnl.add(btnCambiarContraseña);
		pnl.add(btnAtras);
		getContentPane().add(pnl, BorderLayout.CENTER);
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaOpciones vpa = new VentanaOpciones();
				vpa.setVisible(true);
				dispose();
			}
		});
		

		btnCambiarNombre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario u = Supermercado.getUsuarioActual();
				int pos = 0;
				for(int i=0; i<Supermercado.getListaUsuarios().size(); i++) {
					if(Supermercado.existeUsuario(u))
						pos = i;	//Guardamos la posición donde se encuentra el usuario actual dentro del array de usuarios.
				}
				String nick = txtNick.getText();
				if(!Supermercado.existeUsuario(nick) && !nick.isEmpty()) {	//Si no existe el nuevo nombre de usuario
					ArrayList<Usuario> aUsuarios = Supermercado.getListaUsuarios();
					Usuario usu = aUsuarios.get(pos);
					aUsuarios.remove(pos);
					usu.setNick(nick);
					aUsuarios.add(usu);
					Supermercado.setListaUsuarios(aUsuarios);
					Supermercado.setUsuarioActual(usu);
					lblNick.setText("*Su nick actual es " + Supermercado.getUsuarioActual().getNick());
					txtNick.setText("");
					System.out.println(Supermercado.getListaUsuarios());
				}else if(nick.isEmpty()) {
					JOptionPane.showMessageDialog(null, "El campo está vacío.");
				}
				
			}
		});

		btnCambiarContraseña.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario usuarioActual = Supermercado.getUsuarioActual();
				String pw = txtPw.getText();
				ArrayList<Usuario> aUsuarios = Supermercado.getListaUsuarios();
				if(!pw.isEmpty()) {
					for(Usuario u: aUsuarios) {
						if(u.getNick().equals(usuarioActual.getNick())) {
							u.setPassword(pw);
						}
					}
					Supermercado.setListaUsuarios(aUsuarios);
					System.out.println(Supermercado.getListaUsuarios());
					txtPw.setText("");
					lblPW.setText("*Su contraseña ha sido actualizada");
				}else {
					JOptionPane.showMessageDialog(null, "El campo está vacío.");
				}
			}
		});

		txtNick.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				String nick;
				nick = txtNick.getText();
				if(Supermercado.existeUsuario(nick)) { //si existe el nick en la lista de usuarios
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nick. Inserte otro diferente.");
				}
			}
			public void focusGained(FocusEvent e) {
			}});
	}
}
