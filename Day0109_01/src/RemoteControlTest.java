
public class RemoteControlTest {
	public static void main(String[] args) {
		RemoteControl rc1 = new Audio();
		RemoteControl rc2 = new RemoteControl() {
			
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("스위치온");
			}
			
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("아 꺼짐");
			}
			
			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub
				System.out.println("비트에 몸을 맏길 수치를 " +volume+ "으로 셋");
			}
		};
		
		rc1.turnOff();
		rc2.turnOff();
		rc1.setVolume(20);
		rc2.setVolume(20);
	}
}
