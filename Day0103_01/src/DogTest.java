
public class DogTest {
	public static void main(String[] args) {
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		Dog d3 = new Dog();
		
		d1.setType("�㽺Ű");
		d2.setType("Ǫ��");
		d3.setType("�˰�");
		
		d1.setAge(2);
		d2.setAge(1);
		d3.setAge(10);
		
		d1.setCute(true);
		d2.setCute(true);
		d3.setCute(false);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}
}
