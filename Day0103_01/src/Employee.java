
//이름 연봉 부서 정보를 상태로갖는 직원데이터를 만들기 위한 클래스를 작성
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
		return "이름 : " + name + "연봉 : " + salary + "부서 : " + dept;
	}
}
