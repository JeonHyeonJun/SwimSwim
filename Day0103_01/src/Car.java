//Car클래스 속도 주행거리 색상을 갖도록 상태 셋팅 겟셋 투스트링
//CarTest클래스 Car객체 두어개 만들어서 상태값 세팅하고 객체의 상태를 투스트링을 이용해 출력
public class Car {
	private int speed;
	private int mileage;
	private String color;

	public Car(){							//매개변수없는 기본생성자를 통해서도 객체를 만들고 싶다면 기본생성자를 수동으로 정의해야한다.
		speed = mileage = 0;					//기본값입력해줌 ㅇㅇ
		color = "색상미정";
	}
	
	public Car(String color){				//생성자
		this.color = color;
		System.out.println("매개변수1개");
//		System.out.println("Hello Constructor");
//		speed = 0;
//		mileage = 0;							//초기값지정 또는 객체 생성시 필요한작업
//		color = "white";
	}
	public Car(int a, int b, String c){		//생성자도 메소드이므로 오버로딩 할 수 있다!
		speed = a;
		mileage = b;
		color = c;
		System.out.println("매개변수3개");
	}
	
	public void setSpeed(int n) {			//오버로딩. 정수넣을시 정수출력
		System.out.println("정수");	
			speed = n;
	}
	public void setSpeed(double n){			//오버로딩. 실수넣을시 실수출력
		System.out.println("실수");
		speed = (int)(n+0.5);				//반올림
	}
	public int getSpeed() {
		return speed;
	}

	public void setmileage(int n) {
			mileage = n;
	}
	public int getmileage() {
		return mileage;
	}

	public void setColor(String n) {
		color = n;
	}
	public String getColor() {
		return color;
	}

	public String toString() {
		return "속도 : " + speed+ " 주행거리 : " + mileage + " 색상 : " + color;
	}
}
