//삼각형의 높이와 밑변을입력받아서
//해당 삼각형의 넓이를 출력하는 프로그램

//높이입력
//
//밑변입력
//
//해당 삼각형의 넓이는 000 입니다.
import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double height;
		double down;
		double result;

		System.out.println("높이를 입력하세요");
		height = scan.nextDouble();

		System.out.println("밑변을 입력하세요");
		down = scan.nextDouble();

		result = height * down / 2;
		System.out.printf("해당 삼각형의 넓이는 %.2f입니다", result);

	}
}
