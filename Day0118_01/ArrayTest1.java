import java.util.Scanner;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] salary = new int[2];
		Scanner scan = new Scanner(System.in);
		System.out.println("직원1 월급");
		salary[0] = scan.nextInt();
		System.out.println("직원2 월급");
		salary[1] = scan.nextInt();
		System.out.println("직원1 월급은" + salary[0]);
		System.out.println("직원2 월급은" + salary[1]);
	}
}
