//CarŬ���� �ӵ� ����Ÿ� ������ ������ ���� ���� �ټ� ����Ʈ��
//CarTestŬ���� Car��ü �ξ ���� ���°� �����ϰ� ��ü�� ���¸� ����Ʈ���� �̿��� ���
public class Car {
	private int speed;
	private int mileage;
	private String color;

	public Car(){							//�Ű��������� �⺻�����ڸ� ���ؼ��� ��ü�� ����� �ʹٸ� �⺻�����ڸ� �������� �����ؾ��Ѵ�.
		speed = mileage = 0;					//�⺻���Է����� ����
		color = "�������";
	}
	
	public Car(String color){				//������
		this.color = color;
		System.out.println("�Ű�����1��");
//		System.out.println("Hello Constructor");
//		speed = 0;
//		mileage = 0;							//�ʱⰪ���� �Ǵ� ��ü ������ �ʿ����۾�
//		color = "white";
	}
	public Car(int a, int b, String c){		//�����ڵ� �޼ҵ��̹Ƿ� �����ε� �� �� �ִ�!
		speed = a;
		mileage = b;
		color = c;
		System.out.println("�Ű�����3��");
	}
	
	public void setSpeed(int n) {			//�����ε�. ���������� �������
		System.out.println("����");	
			speed = n;
	}
	public void setSpeed(double n){			//�����ε�. �Ǽ������� �Ǽ����
		System.out.println("�Ǽ�");
		speed = (int)(n+0.5);				//�ݿø�
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
		return "�ӵ� : " + speed+ " ����Ÿ� : " + mileage + " ���� : " + color;
	}
}
