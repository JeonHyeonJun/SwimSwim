import java.util.Scanner;

public class Add2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x;
		int y;
		int sum;

		System.out.println("첫번째수입력");
		x = scan.nextInt();
		System.out.println("두번째수입력");
		y = scan.nextInt();
		sum = x + y;
		System.out.println(x + "+" + y + "=" + sum);

	}
}
