package kr.mulcam.c1102.hello;

public class HelloWorld {
	public static void main(String[] args) {
		long a;
		long b;
		long c;
		
		a = System.currentTimeMillis();
		for(int i=0; i<1000; i++)
			System.out.println("hello world");
		
		b = System.currentTimeMillis();
		
		c= b-a;
		System.out.println(c);
	}
	
}
