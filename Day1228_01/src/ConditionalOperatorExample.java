import java.util.Scanner;

public class ConditionalOperatorExample {
	public static void main(String[] args) {
		// ����ڷκ��� �ΰ��� ���ڸ� �Է¹޾Ƽ�
		// �� �� �� �� ū ���� ������ִ� ���α׷�
		Scanner scan = new Scanner(System.in);
		int num1;
		int num2;
		int num3;
		int max;
		int min;
		int mid, mid2;
		int tmp, tmp2, tmp3;

		System.out.println("ù��°���ڸ��Է��ϼ���");
		num1 = scan.nextInt();
		System.out.println("�ι�°���ڸ��Է��ϼ���");
		num2 = scan.nextInt();
		System.out.println("����°���ڸ��Է��ϼ���");
		num3 = scan.nextInt();

		tmp = (num1 > num2) ? num1 : num2;
		max = tmp > num3 ? tmp : num3;
		System.out.printf("%d�� %d�� %d �߿� �� ū���� %d�Դϴ�\n", num1, num2, num3, max);
		tmp = (num1 < num2) ? num1 : num2;
		min = (tmp < num3) ? tmp : num3;
		System.out.printf("%d�� %d�� %d �߿� �������� %d�Դϴ�\n", num1, num2, num3, min);
		mid = num1 + num2 + num3 - max - min;
		System.out.printf("%d�� %d�� %d �߿� �߰����� %d�Դϴ�\n", num1, num2, num3, mid);
		tmp = num1 > num2 ? num1 : num2;
		tmp2 = num2 > num3 ? num2 : num3;
		tmp3 = num1 > num3 ? num1 : num3;
		mid = tmp < tmp2 ? tmp : tmp2;
		mid2 = mid < tmp3 ? mid : tmp3;
		System.out.printf("%d�� %d�� %d �߿� �߰����� %d�Դϴ�\n", num1, num2, num3, mid2);

	}
}
