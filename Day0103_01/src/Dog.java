
public class Dog {
	private String type;
	private int age;
	private boolean cute;
	private String cuty;

	public void setType(String t) {
		type = t;
	}
	public String getType() {
		return type;
	}

	public void setAge(int a) {
		if (a > 0)
			age = a;
	}
	public int getAge() {
		return age;
	}

	public void setCute(boolean c) {
		if (c)
			cuty = "�Ϳ���";
		else
			cuty = "�ȱͿ���";
	}
	public String getCute() {
		return cuty;
	}

	public String toString() {
		return "�� : " + getType() + " ���� : " + getAge() + " " +getCute();
	}
}
