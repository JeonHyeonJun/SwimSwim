
public class Employee {
	private String name;
	private double salary;
	
	private static int count = 0;
	
	public Employee(String n, double s){
		name = n;
		salary = s;
		count++;
	}
	
	//객체가 소멸될때 발동!하지만 언제 소멸될지 모르니까 활용도는 없다
	protected void finalize(){
		count--;
	}
	
	public static int getCount(){
		return count;
	}
}
