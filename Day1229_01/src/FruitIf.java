import java.util.Scanner;

public class FruitIf {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println((int)(Math.random()*10)+1);
		System.out.print("1~10중의 숫자를 입력해주세요오오");
		num = scan.nextInt();

		if (num == 1)
			System.out.println("Bananas");
		else if (num == 2)
			System.out.println("Oranges");
		else if (num == 3) {
			System.out.println("Pears");
			System.out.println("Apples");
			System.out.println("Plums");
		} else if (num == 4) {
			System.out.println("Apples");
			System.out.println("Plums");
		} else if (num == 5)
			System.out.println("Plums");
		else if (num == 6)
			System.out.println("Pineapples");
		else if (num == 7)
			;
		else
			System.out.println("Nuts");
	}
}
