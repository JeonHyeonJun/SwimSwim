import java.util.Scanner;

public class Size {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size;

		System.out.print("컵사이즈를 입력해주세요");
		size = scan.nextInt();

		switch (size / 100) {
		case 0:
			System.out.println("small");
			break;
		case 1:
			System.out.println("medium");
			break;
		default:
			System.out.println("large");
			break;
		}

		/*
		 * if(size<100) System.out.println("small"); else if(size>=100
		 * &&size<200) System.out.println("medium"); else
		 * System.out.println("large");
		 */
	}
}
