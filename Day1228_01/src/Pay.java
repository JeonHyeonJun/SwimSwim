import java.util.Scanner;

public class Pay {
	public static void main(String[] args) {
		final int RATE = 5000;
		int pay;
		int hours;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�ð��� �����ϼ���");
		hours = scan.nextInt();
		if(hours>8)
			pay = RATE*8+(int)(15*RATE*(hours-8));
		else
			pay = RATE * hours;
		System.out.printf("�ӱ��� %d�Դϴ�\n",pay);
	}
}
