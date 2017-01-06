
class Animal{
	public String name;
	
	public void bark(){
		System.out.println("������ �����Ҹ�");
	}
}

class Dog extends Animal{
	public void bark(){
		System.out.println("�۸�");
	}
}

class Cow extends Animal{
	public void bark(){
		System.out.println("��������");
	}
}

class Cat extends Animal{
	public void bark(){
		System.out.println("�Ŀ�߿�");
	}
}

public class AnimalTest {
	private static Animal animal[] ;
	public static void main(String[] args) {
		save();
		shout();
	}
	
	public static void save(){
		animal = new Animal[3];
		animal[0] = new Dog();
		animal[1] = new Cow();
		animal[2] = new Cat();
	}
	
	public static void shout(){
		for(int i=0; i<animal.length; i++)
			animal[i].bark();
	}
}
