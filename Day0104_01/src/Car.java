
public class Car {
	private int speed;
	private int mileage;
	private String color;
	private int id;
	private static int numberOfCars = 0;			//정적변수/클래스변수
													//객체가 없든많든 하나만 존재. 모든객체에서 접근가능해서 개체들이 공유하는 데이터공간으로 활용가능.
	static final int MAX_SPEED = 200;			//모든 객체가 같은 값으로 공유해야하는 상수에 활용
	
	public Car(int s, int m, String c){
		speed =s;
		mileage = m;
		color = c;
		id = ++numberOfCars;
	}
	
	public void sppedUp(int s)
	{
		
		if(speed + s <MAX_SPEED)
			speed += s;
		else
			speed = MAX_SPEED;
	}
	public void setSpeed(int speed){
		if(speed>MAX_SPEED)
			this.speed = speed;
		else
			this.speed = MAX_SPEED;
	}
	
	public static int getNumberOfCars(){		//정적메소드의 용도1 - 정적변수에 대한 게터, 세터
//		System.out.println(color);				//정적메소드에서는 멤버 변수나 멤버 함수에접근불가, 없을수도 있고 많을 수도 있기때문
//		speedUp(10);	
		return numberOfCars;					
	}
	
	public String toString(){
		return "Car [speed=" +speed+ " mileage=" +mileage+  " color=" +color+ " id=" +id+"]";
	}
}
