
public class Audio implements RemoteControl{

	private int volume;
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("오디오를 킵니당");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("오디오를 끕니당");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if( volume > RemoteControl.MAX_VOLUME )
			this.volume = RemoteControl.MAX_VOLUME;
		else if( volume < RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else
			this.volume = volume;
		
		System.out.println("현재 Audio 볼륨: " +this.volume);
	} 	

}
