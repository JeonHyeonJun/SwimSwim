import java.util.Scanner;

public class Tax {
	public static void main(String[] args) {
		int income;	//����ǥ��
		int tax;	//����
		System.out.print("����ǥ�رݾ��� �Է��غ���");
		Scanner scan = new Scanner(System.in);
		income = scan.nextInt();
		if (income <= 1000)
			tax = (int) (0.09 * income);
		else if (income <= 4000)
			tax = (int) (0.18 * income);
		else if (income < 8000)
			tax = (int) (0.27 * income);
		else
			tax = (int) (0.36 * income);
		System.out.println("�ҵ漼�� " + tax + "�Դϴ�");
	}
}
