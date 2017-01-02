import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Lotto[] = new int[6];
		int num = 0;
		boolean sw = true;

		while (sw) {
			sw = false;
			for (int k = 0; k < Lotto.length; k++) {
				num = (int) (Math.random() * 6) + 1;
				Lotto[k] = num;
			}
			for (int i = 0; i < Lotto.length; i++) {
				for (int j = i + 1; j < Lotto.length; j++) {
					if (Lotto[i] == Lotto[j])
						sw = true;
				}
			}
		}

		for (int i = 1; i < Lotto.length; i++)
			System.out.print(Lotto[i] + " ");
	}
}
