
class MyRunnable implements Runnable{
	String myName;
	public MyRunnable(String name){
		myName = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			System.out.println(myName + i);
		}
	}
}

public class TestThread{
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable("First Thread"));
		Thread t2 = new Thread(new MyRunnable("Second Thread"));
		t1.start();
		t2.start();
	}
}