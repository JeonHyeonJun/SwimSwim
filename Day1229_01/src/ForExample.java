import java.util.Scanner;

public class ForExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;

		System.out.println("¸î´Ü?");
		num = scan.nextInt();

		for (int i = 1; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + num * i);
		}
	}
}
