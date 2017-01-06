
public class Car {
	public int speed;
	public int gear;
	public String color;
	
	public void setGear(int newGear){
		gear = newGear;
	}
	public void speedUp(int increment){
		speed += increment;
	}
	public void speedDown(int decrement){
		speed -= decrement;
	}
	
	public final void stop(){
		System.out.println("Â÷°¡ ¸ØÃã");
		speed = 0;
	}
}
