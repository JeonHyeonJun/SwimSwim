
public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try{
			sumThread.join();	//sumThread가 끝날때까지 다음으로 넘어가지 않음
		} catch (InterruptedException e) {
		}
		
		System.out.println("1~100 합: " +sumThread.getSum());
	}
}
