
public class Child extends Parent {
	private String name;
	
	public Child(){
		this("ȫ�浿");			//Child("ȫ�浿") �� ���� �ǹ�
		System.out.println("Child() call");
	}
	
	public Child(String name){
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
