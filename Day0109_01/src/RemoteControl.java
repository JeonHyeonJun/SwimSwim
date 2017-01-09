
public interface RemoteControl {
	//상수정의
	public static final int MAX_VOLUME = 10;	//요 인터페이스를 구현하는 클래스는 이 상수들을 가짐
	public static final int MIN_VOLUME = 0;
	
	//추상메소드 정의									//미완성함수로 요 인터페이스를 implements하는 클래스는 요 함수들을 의무적으로 구현하거나 안할거면 추상클래스가 되어야함
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);
	
	//디폴트메소드
	default void setMute(boolean mute){
		if(mute){
			System.out.println("무음 처리합니당");
		} else {
			System.out.println("무음 해제합니당");
		}
	}
	
	//정적메소드
	public static void changeBattery(){
		System.out.println("건전지를 교환합니당");
	}
	
}
