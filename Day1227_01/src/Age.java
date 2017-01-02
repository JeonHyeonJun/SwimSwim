import java.util.Scanner;

public class Age {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int year;
		int o;

		System.out.print("몇살이세요? ");
		year = scan.nextInt();

		// o = year/10*10;
		o = year - year % 10;
		System.out.printf("당신은 %d대 이군요", o);
	}
}
