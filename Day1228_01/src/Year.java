//사용자로부터 연도를 입력받아서
//윤년인지 평년인지 여부를 출력하는 프로그램

// 1. 4로 나누어 떨어지는 ㅎ는 우선 윤년
// 2. 그 중에서 100으로 나누어 떨어지는 해는 평년
// 3. 다만 400으로 나누어 떨어지는 해는 다시 윤년
import java.util.Scanner;

public class Year {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year;
		int na, na2, na3;
		String result;

		System.out.print("연도를 입력하세요");
		year = scan.nextInt();

		na = year % 4;
		na2 = year % 100;
		na3 = year % 400;
		result = (na == 0 && na2 != 0) || na3 == 0 ? "윤년" : "평년";
		System.out.println(result);
	}
}
