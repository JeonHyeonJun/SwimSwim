
//�̸� ���� �μ� ������ ���·ΰ��� ���������͸� ����� ���� Ŭ������ �ۼ�
public class Employee {
	private String name;
	private int salary;
	private String dept;
	
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	
	public void setSalary(int n){
		if(n>0)
		salary = n;
	}
	public int getSalary(){
		return salary;
	}
	
	public void setDept(String n){
		dept = n;
	}
	public String getDept(){
		return dept;
	}
	
	public String toString() {
		return "�̸� : " + name + "���� : " + salary + "�μ� : " + dept;
	}
}
