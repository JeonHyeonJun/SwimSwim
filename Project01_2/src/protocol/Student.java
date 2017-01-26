package protocol;

public class Student {
	private String stnumber;
	private String name;
	private String id;
	private String password;
	
	public String getStnumber() {
		return stnumber;
	}
	public void setStnumber(String stnumber) {
		this.stnumber = stnumber;
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
		return "Student [stnumber=" + stnumber + ", name=" + name + ", id=" + id + ", password=" + password + "]";
	}
	
	
}
