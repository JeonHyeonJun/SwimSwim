
public class CarTest {
	public static void main(String[] args) {
		
		System.out.println("���� �ڵ��� �� : " +Car.getNumberOfCars());
		Car oppacha = new Car(100,2000,"�Ͼ��");
		Car appacha = new Car(90,3000,"������");
		
		System.out.println(oppacha);
		System.out.println(appacha);
		
		System.out.println(Car.getNumberOfCars());
	}
}
