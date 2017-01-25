package protocol;

import java.io.Serializable;

public class Account implements Serializable{
	
	
	private static final long serialVersionUID = 2004;
	private String ano;
	private String name;
	private int bal;
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Account [ano=" + ano + ", name=" + name + ", bal=" + bal + "]";
	}
	
	
}
