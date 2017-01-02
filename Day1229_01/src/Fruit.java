import java.util.Scanner;

public class Fruit {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;

		System.out.print("1~10ÁßÀÇ ¼ýÀÚ¸¦ °ñ¶óºÁ");
		num = scan.nextInt();

		switch (num) {
		case 1:
			System.out.println("Bananas");
			break;
		case 2:
			System.out.println("Oranges");
			break;
		case 3:
			System.out.println("Pears");
		case 4:
			System.out.println("Apples");
		case 5:
			System.out.println("Plums");
			break;
		case 6:
			System.out.println("Pineapples");
			break;
		case 7:
			break;
		default:
			System.out.println("Nuts");
			break;
		}
	}
}
