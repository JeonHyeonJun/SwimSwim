import java.util.Scanner;

public class Pay {
	public static void main(String[] args) {
		final int RATE = 5000;
		int pay;
		int hours;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("시간을 지배하세요");
		hours = scan.nextInt();
		if(hours>8)
			pay = RATE*8+(int)(15*RATE*(hours-8));
		else
			pay = RATE * hours;
		System.out.printf("임금은 %d입니다\n",pay);
	}
}
