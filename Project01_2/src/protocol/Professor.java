package protocol;

import java.io.Serializable;

public class Professor implements Serializable{
	private String prnumber;
	private String name;
	private String id;
	private String password;
	
	public String getPrnumber() {
		return prnumber;
	}
	public void setPrnumber(String prnumber) {
		this.prnumber = prnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Professor [prnumber=" + prnumber + ", name=" + name + ", id=" + id + ", password=" + password + "]";
	}
	
	
}
