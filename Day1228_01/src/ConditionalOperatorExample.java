import java.util.Scanner;

public class ConditionalOperatorExample {
	public static void main(String[] args) {
		// 사용자로부터 두개의 숫자를 입력받아서
		// 두 수 중 더 큰 수를 출력해주는 프로그램
		Scanner scan = new Scanner(System.in);
		int num1;
		int num2;
		int num3;
		int max;
		int min;
		int mid, mid2;
		int tmp, tmp2, tmp3;

		System.out.println("첫번째숫자를입력하세요");
		num1 = scan.nextInt();
		System.out.println("두번째숫자를입력하세요");
		num2 = scan.nextInt();
		System.out.println("세번째숫자를입력하세요");
		num3 = scan.nextInt();

		tmp = (num1 > num2) ? num1 : num2;
		max = tmp > num3 ? tmp : num3;
		System.out.printf("%d과 %d과 %d 중에 더 큰수는 %d입니다\n", num1, num2, num3, max);
		tmp = (num1 < num2) ? num1 : num2;
		min = (tmp < num3) ? tmp : num3;
		System.out.printf("%d과 %d과 %d 중에 작은수는 %d입니다\n", num1, num2, num3, min);
		mid = num1 + num2 + num3 - max - min;
		System.out.printf("%d과 %d과 %d 중에 중간수는 %d입니다\n", num1, num2, num3, mid);
		tmp = num1 > num2 ? num1 : num2;
		tmp2 = num2 > num3 ? num2 : num3;
		tmp3 = num1 > num3 ? num1 : num3;
		mid = tmp < tmp2 ? tmp : tmp2;
		mid2 = mid < tmp3 ? mid : tmp3;
		System.out.printf("%d과 %d과 %d 중에 중간수는 %d입니다\n", num1, num2, num3, mid2);

	}
}
