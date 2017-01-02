import java.util.Scanner;

public class Rank {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sc = 0;
		char ran = 'N';

		System.out.println("점수를입력하세요");
		sc = scan.nextInt();

		/*
		 * ran = 90<=sc ? 'A':'F'; ran = 90>sc && 80<=sc ? 'B':ran; ran = 80>sc
		 * && 70<=sc ? 'C':ran; ran = 70>sc && 60<=sc ? 'D':ran;
		 */

		ran = sc > 90 ? 'A' : sc > 80 ? 'B' : sc > 70 ? 'C' : sc > 60 ? 'D' : 'F';

		System.out.println(ran);
	}
}
