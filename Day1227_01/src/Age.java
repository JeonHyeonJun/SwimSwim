import java.util.Scanner;

public class Age {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int year;
		int o;

		System.out.print("����̼���? ");
		year = scan.nextInt();

		// o = year/10*10;
		o = year - year % 10;
		System.out.printf("����� %d�� �̱���", o);
	}
}
