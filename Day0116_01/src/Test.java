
//class Counting extends Thread {
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		// super.run();
//		System.out.println(Thread.currentThread());
//		for (int i = 0; i < 10; i++)
//			System.out.println(i);
//	}
//}

class Counting implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++)
			System.out.println(i);
	}
}

public class Test {
	public static void main(String[] args) {
		Counting c = new Counting();	//Runnable 구현객체를
		Thread t1 = new Thread(c);		//Thread클래스의 생성자에 전달
		t1.start();
		
//		Thread t1 = new Counting();
//		t1.start();					//start()는 새로운 명령처리흐름을 만들어서 run()실행하라고 하고 갈길감
//		Thread t2 = new Counting();
//		t2.start();
//		
//		t1.run();					//이건그냥 run()함수 실행
	}
}
