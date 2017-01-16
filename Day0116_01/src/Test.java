
class Counting extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		for (int i = 0; i < 10; i++)
			System.out.println(i);
	}
}

public class Test {
	public static void main(String[] args) {
		Thread t = new Counting();
		t.start();
	}
}
