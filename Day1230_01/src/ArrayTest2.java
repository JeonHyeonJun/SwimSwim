//배열의 크기를 입력받고 double형 배열을 생성하라
import java.util.Scanner;

public class ArrayTest2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size;

		System.out.print("배열의 크기를 입력하세요");
		size = scan.nextInt();
		double[] array = new double[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("넣을값을 입력하세요");
			array[i] = scan.nextDouble();
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println("배열[" + i + "]의 값은" + array[i] + "입니다");
		}
	}
}
