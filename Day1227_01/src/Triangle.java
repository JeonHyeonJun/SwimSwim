//�ﰢ���� ���̿� �غ����Է¹޾Ƽ�
//�ش� �ﰢ���� ���̸� ����ϴ� ���α׷�

//�����Է�
//
//�غ��Է�
//
//�ش� �ﰢ���� ���̴� 000 �Դϴ�.
import java.util.Scanner;

public class Triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double height;
		double down;
		double result;

		System.out.println("���̸� �Է��ϼ���");
		height = scan.nextDouble();

		System.out.println("�غ��� �Է��ϼ���");
		down = scan.nextDouble();

		result = height * down / 2;
		System.out.printf("�ش� �ﰢ���� ���̴� %.2f�Դϴ�", result);

	}
}
