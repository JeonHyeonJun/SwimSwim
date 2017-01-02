import java.util.Scanner;

public class ScoreTest {
	public static void main(String[] args) {
		int total = 0;
		int size;
		Scanner scan = new Scanner(System.in);
		System.out.print("배열의 크기를 입력 : ");
		size = scan.nextInt();
		int[] scores = new int[size];
		for (int i = 0; i < scores.length; i++) {
			System.out.print("성적입력 : ");
			scores[i] = scan.nextInt();
		}
		for (int i = 0; i < scores.length; i++)
			total += scores[i];
		System.out.println("평균 성적은" + total / scores.length + "입니다");
	}
}
