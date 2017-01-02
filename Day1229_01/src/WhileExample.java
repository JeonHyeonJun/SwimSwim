import java.util.Scanner;

public class WhileExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		int i = 1;

		System.out.print("¸î´Ü?");
		num = scan.nextInt();

		while (i < 10) {
			System.out.println(num + " * " + i + " = " + num * i);
			i++;
		}

	}
}
