
public class Child extends Parent {
	private String name;
	
	public Child(){
		this("홍길동");			//Child("홍길동") 와 같은 의미
		System.out.println("Child() call");
	}
	
	public Child(String name){
		this.name = name;
		System.out.println("Child(String name) call");
	}
}
