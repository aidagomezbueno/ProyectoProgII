package Datos;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nick, password;

	public Usuario(String nick, String password) {
		super();
		this.nick = nick;
		this.password = password;
	}

	public Usuario() {
		super();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nick = " + nick + ", password = " + password + "]";
	}
	
	

}
