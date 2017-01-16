import java.util.Random;

class Horse implements Runnable {
	String name;
	private int sleepTime;
	private final static Random generator = new Random();
	
	public Horse(String name) {
		this.name = name;
		sleepTime = generator.nextInt(3000);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(sleepTime);
		} catch (InterruptedException e){
		}
		System.out.println(name + "말이 경주를 완료하였습니다.");
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Horse("질풍"));
		Thread t2 = new Thread(new Horse("천둥"));
		Thread t3 = new Thread(new Horse("열혈"));
		Thread t4 = new Thread(new Horse("섬광"));
		Thread t5 = new Thread(new Horse("어둠"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
