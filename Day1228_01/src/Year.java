//����ڷκ��� ������ �Է¹޾Ƽ�
//�������� ������� ���θ� ����ϴ� ���α׷�

// 1. 4�� ������ �������� ���� �켱 ����
// 2. �� �߿��� 100���� ������ �������� �ش� ���
// 3. �ٸ� 400���� ������ �������� �ش� �ٽ� ����
import java.util.Scanner;

public class Year {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year;
		int na, na2, na3;
		String result;

		System.out.print("������ �Է��ϼ���");
		year = scan.nextInt();

		na = year % 4;
		na2 = year % 100;
		na3 = year % 400;
		result = (na == 0 && na2 != 0) || na3 == 0 ? "����" : "���";
		System.out.println(result);
	}
}
