
class Car{
	public int speed;
	public int mileage;
	public String color;
	
	public void speedUp(int increase)
	{
		speed += increase;
	}
	public void speedDown(int decrease)
	{
		speed -= decrease;
	}
	public String toString(){
		return "�ӵ�  : " +speed+ "\t����Ÿ� : " +mileage+ "\t���� : " +color;
	}
}

public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.speed = 100;
		c1.mileage = 1200;
		c1.color = "�Ķ���";
		
		Car c2 = new Car();
		c2.speed = 90;
		c2.mileage = 2100;
		c2.color = "�Ͼ��";
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		c1.speedUp(15);
		c2.speedDown(20);
		System.out.println("------------------------------------------");
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}
