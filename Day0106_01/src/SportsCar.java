
public class SportsCar extends Car{
	boolean turbo;
	
	public void setTurbo(boolean newValue){
		turbo = newValue;
	}
	
	public void speedUp(){
		speed += 1;
	}
	
//	public void stop(){							//final �޼ҵ�� �������̵��� �� ����!
//		System.out.println("������ī�� ����");	
//		speed = 0;
//	}
}
