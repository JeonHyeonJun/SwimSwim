import java.util.Scanner;
public class Dollar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int won;
		double dollar=1205.30;
		
		System.out.print("원화입력 : ");
		won = scan.nextInt();
		
		dollar = won/dollar;
		System.out.printf("%d원은 %.2f달러입니다 ",won,dollar);
	}
}
