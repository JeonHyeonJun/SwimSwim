
public class SportsCar extends Car{
	boolean turbo;
	
	public void setTurbo(boolean newValue){
		turbo = newValue;
	}
	
	public void speedUp(){
		speed += 1;
	}
	
//	public void stop(){							//final 메소드는 오버라이딩할 수 없다!
//		System.out.println("스포츠카를 멈춤");	
//		speed = 0;
//	}
}
