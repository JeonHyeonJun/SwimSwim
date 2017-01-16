
public class StopFlagExample {
	public static void main(String[] args) {
		//interrupt로 Thread종료
		Thread thread = new PrintThread1();
		thread.start();
		
		try{
			Thread.sleep(1000);
		} catch(InterruptedException e){}
		
		thread.interrupt();
		
		//while문 조건으로 Thread종료
//		PrintThread1 printThread = new PrintThread1();
//		printThread.start();
//		
//		try{
//			Thread.sleep(1000);
//		} catch (InterruptedException e){}
//		
//		printThread.setStop(true);
	}
}
