
public class CarTest {
	public static void main(String[] args) {
		Car[] car = new Car[5];	//Car[] car -> 자동차객체의 위치를 저장할수 있는 Car참조변수
		
		car[0] = new Car(100, 300, "White");
		car[1] = new Car(110, 130, "Red");
		car[2] = new Car(90, 320, "Blue");
		car[3] = new Car(70, 330, "Green");
		car[4] = new Car(120, 430, "Black");
		
		for(int i=0; i<car.length; i++)
			System.out.println(car[i]);
	}
}
