
public class Parent {
	public String nation;
	
	public Parent(){
		this("���ѹα�");			//Parent("���ѹα�") �� �����ǹ�
		System.out.println("Parent() call");
	}
	
	public Parent(String nation){
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
