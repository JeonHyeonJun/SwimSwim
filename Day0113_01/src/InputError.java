import java.util.InputMismatchException;
import java.util.Scanner;

public class InputError {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int i = 0;
		System.out.println("정수를 입력하시오");
		try {
			i = scan.nextInt();
			System.out.println("입력받은 정수의 값: " + i);
		} catch (InputMismatchException e) {
			System.out.println("정수가 아닙니다");
		}
	}
}
