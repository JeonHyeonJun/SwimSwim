import java.util.Scanner;

public class Salary {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int salary;
		int deposit;

		System.out.print("월급입력 : ");
		salary = scan.nextInt();

		deposit = 10 * 12 * salary;
		System.out.printf("10년동안저축액 : %d\n", deposit);
		System.out.printf("한달에 %d만큼받으셔서는 %d밖에 못받으십니다", salary, deposit);
	}
}
