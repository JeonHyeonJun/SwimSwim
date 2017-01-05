
public class Car {
	private int speed;
	private int mileage;
	private String color;
	private int id;
	private static int numberOfCars = 0;			//��������/Ŭ��������
													//��ü�� ���縹�� �ϳ��� ����. ��簴ü���� ���ٰ����ؼ� ��ü���� �����ϴ� �����Ͱ������� Ȱ�밡��.
	static final int MAX_SPEED = 200;			//��� ��ü�� ���� ������ �����ؾ��ϴ� ����� Ȱ��
	
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
	
	public static int getNumberOfCars(){		//�����޼ҵ��� �뵵1 - ���������� ���� ����, ����
//		System.out.println(color);				//�����޼ҵ忡���� ��� ������ ��� �Լ������ٺҰ�, �������� �ְ� ���� ���� �ֱ⶧��
//		speedUp(10);	
		return numberOfCars;					
	}
	
	public String toString(){
		return "Car [speed=" +speed+ " mileage=" +mileage+  " color=" +color+ " id=" +id+"]";
	}
}
