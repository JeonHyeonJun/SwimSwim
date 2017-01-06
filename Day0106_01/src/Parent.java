
public class Parent {
	public String nation;
	
	public Parent(){
		this("대한민국");			//Parent("대한민국") 과 같은의미
		System.out.println("Parent() call");
	}
	
	public Parent(String nation){
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
