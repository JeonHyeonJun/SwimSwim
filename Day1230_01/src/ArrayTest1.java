import java.util.Scanner;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] salary = new int[2];
		Scanner scan = new Scanner(System.in);
		System.out.print("����1�� �����Է�");
		salary[0] = scan.nextInt();
		System.out.print("����2�� �����Է�");
		salary[1] = scan.nextInt();
		System.out.println("����1�� ������ "+salary[0]);
		System.out.println("����2�� ������ "+salary[1]);
	}
}
