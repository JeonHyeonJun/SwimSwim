
public class Car {
	private String model;
	
	public Car(String model){
		this.model = model;
	}
	
	public String getMode(){
		return model;
	}
	
//	public boolean equals(Object obj){
//		if (obj instanceof Car)
//			return model.equals(((Car) obj).getMode());
//		else
//			return false;
//	}
	
	public static void main(String[] args) {
		Car firstCar = new Car("HMW520");
		Car secondCar = new Car("HMW520");
		if(firstCar.equals(secondCar)){
			System.out.println("������ ������ �ڵ����Դϴ�.");
		} else {
			System.out.println("�������� ���� ������ �ڵ����Դϴ�.");
		}
	}
}
