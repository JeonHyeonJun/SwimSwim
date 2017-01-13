import java.io.IOException;

public class Test1 {
	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 1;
		
		if( num2 == 1)
			throw new ArithmeticException();	//num2가1이면 에러발생하게 만듦
		
		//		System.out.println(readString());
//	}
//	
//	public static String readString(){
//		byte[] buf = new byte[100];
//		System.out.println("문자열을 입력하시오:");
//		try {
//			System.in.read(buf);
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return new String(buf);
	}
	
	
}
