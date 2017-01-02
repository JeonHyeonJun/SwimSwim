
public class IntegerLitera {
	public static void main(String[] args) {
//		byte num = 300;	//byte가 담을수 있는 최대값을 초과하여 컴파일에러
//		long num = 2200000000;	//리터럴상수 숫자는 int로 간주되기 때문에 int범위를 초과한 상수는 존재하지않아 에러
		long num = 2200000000L; //이렇게 하면 리터럴상수 숫자 long타입이 되기때문에 실행 가능
		
		int i = 26;
		int ix = 032;
		int xi = 0x1a;
		
		System.out.println(num);
		System.out.println(i);
		System.out.println(ix);
		System.out.println(xi);
	}
}
