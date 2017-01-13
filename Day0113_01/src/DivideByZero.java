
public class DivideByZero {
	public static void main(String[] args) {
		int x = 1;
		int y = 0;

		try {
			int result = x / y;
		} catch (ArithmeticException e) {
			System.out.println("0으론 나눌 수 없습니다");
		}
		System.out.println("프로그램은 끝나지 않아요");

		// int result = x/y;
		// System.out.println("이 문장이 출력될꺼같냐");
	}
}
