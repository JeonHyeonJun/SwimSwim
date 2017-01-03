
public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
//		e1.name = "Kim";
//		e2.name = "Hong";
		e1.setName("Kim");
		e2.setName("Hong");
		
//		e1.salary = 1000;
//		e2.salary = 2000;
		e1.setSalary(-1000);
		e2.setSalary(2000);
		
//		e1.dept = "Account";
//		e2.dept = "Development";
		e1.setDept("Account");
		e2.setDept("Development");
		
		System.out.println(e1.toString());
		System.out.println(e2);
	}
}
