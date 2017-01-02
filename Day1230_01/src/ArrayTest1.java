import java.util.Scanner;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] salary = new int[2];
		Scanner scan = new Scanner(System.in);
		System.out.print("직원1의 월급입력");
		salary[0] = scan.nextInt();
		System.out.print("직원2의 월급입력");
		salary[1] = scan.nextInt();
		System.out.println("직원1의 월급은 "+salary[0]);
		System.out.println("직원2의 월급은 "+salary[1]);
	}
}
