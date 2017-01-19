package server;
import java.io.Serializable;

public class Account implements Serializable{
	private String ano;
	private String owner;
	private int balance;
	private static int MIN_BALANCE = 0;
	private static int MAX_BALANCE = 1000000;

	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE)
			this.balance = balance;
	}

	public static int getMIN_BALANCE() {
		return MIN_BALANCE;
	}

	public static int getMAX_BALANCE() {
		return MAX_BALANCE;
	}

//	@Override
//	public boolean equals(Object obj) {
//
//		System.out.println("나불렀썹?");
//		if (obj instanceof Account) {
//			if (this.ano.equals(((Account) obj).ano))
//			return true;
//		}
//		return false;
//	}
//	
//	public int Hashcode(){
//		return ano.hashCode();
//	}

	public String toString() {
		return ano + "    " + owner + "    " + balance;
	}

}
