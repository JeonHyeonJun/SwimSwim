import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int salary;
		int deposit;

		System.out.print("�����Է� : ");
		salary = scan.nextInt();

		deposit = 10 * 12 * salary;
		System.out.printf("10�⵿������� : %d\n", deposit);
		System.out.printf("�Ѵ޿� %d��ŭ�����ż��� %d�ۿ� �������ʴϴ�", salary, deposit);
	}
}
