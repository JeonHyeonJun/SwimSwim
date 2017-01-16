
public class PrintThread1 extends Thread{
	//interrupt형
	public void run(){
		try {
			while(true) {
				System.out.println("실행중");
				Thread.sleep(1);
			}
		} catch(InterruptedException e) {
			System.out.println("자원정리");
		}
		System.out.println("실행종료");
		
	}
	
	//while형
//	private boolean stop;
//	
//	public void setStop(boolean stop) {
//		this.stop = stop;
//	}
//	
//	public void run(){
//		while(!stop){//stop이 true가 될때 끝남
//			System.out.println("실행중");
//		}
//		System.out.println("자원 정리");
//		System.out.println("실행종료");
//	}
}
