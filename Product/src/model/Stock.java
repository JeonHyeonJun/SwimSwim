package model;

public class Stock {
	private String code;
	private String name;
	private int cnt;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "Stock [code=" + code + ", name=" + name + ", cnt=" + cnt + "]";
	}
	
	
}
