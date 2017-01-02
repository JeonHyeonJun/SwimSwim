import java.util.Scanner;

public class Tax {
	public static void main(String[] args) {
		int income;	//과세표준
		int tax;	//세금
		System.out.print("과세표준금액을 입력해보렴");
		Scanner scan = new Scanner(System.in);
		income = scan.nextInt();
		if (income <= 1000)
			tax = (int) (0.09 * income);
		else if (income <= 4000)
			tax = (int) (0.18 * income);
		else if (income < 8000)
			tax = (int) (0.27 * income);
		else
			tax = (int) (0.36 * income);
		System.out.println("소득세는 " + tax + "입니다");
	}
}
