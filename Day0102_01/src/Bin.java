
class C{
	int speed;
	public int mileage;
	public String color;
	
	public void up(int increase){
		speed += increase; 
	}
	public void down(int decrease){
		speed -= decrease;
	}
	public String to(){
		return "�ӵ� : " +speed+ "\t����Ÿ� : "+mileage+"\t���� : "+color;
	}
	public void pr(){
		System.out.println("�ӵ� : " +speed+ "\t����Ÿ� : " +mileage+ "\t���� : " +color);
	}
}

public class Bin {
	public static void main(String[] args) {
		C c1 = new C();
		c1.speed = 100;
		c1.mileage = 1200;
		c1.color = "�Ķ�";
		
		c1.pr();
		System.out.println(c1.to());
	}
}
