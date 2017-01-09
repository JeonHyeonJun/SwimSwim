
class Animal{
	public String name;
	
	public void bark(){
	}
}

class Dog extends Animal{
	public void bark(){
		System.out.println("멍멍");
	}
}

class Cow extends Animal{
	public void bark(){
		System.out.println("음메음메");
	}
}

class Cat extends Animal{
	public void bark(){
		System.out.println("냐옹야용");
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
