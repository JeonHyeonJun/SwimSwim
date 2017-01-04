
public class CarTest {
	public static void main(String[] args) {
		
		System.out.println("현재 자동차 수 : " +Car.getNumberOfCars());
		Car oppacha = new Car(100,2000,"하얀색");
		Car appacha = new Car(90,3000,"검정색");
		
		System.out.println(oppacha);
		System.out.println(appacha);
		
		System.out.println(Car.getNumberOfCars());
	}
}
