import java.util.Scanner;
public class Dollar {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int won;
		double dollar=1205.30;
		
		System.out.print("��ȭ�Է� : ");
		won = scan.nextInt();
		
		dollar = won/dollar;
		System.out.printf("%d���� %.2f�޷��Դϴ� ",won,dollar);
	}
}
