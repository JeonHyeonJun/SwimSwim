//�迭�� ũ�⸦ �Է¹ް� double�� �迭�� �����϶�
import java.util.Scanner;

public class ArrayTest2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size;

		System.out.print("�迭�� ũ�⸦ �Է��ϼ���");
		size = scan.nextInt();
		double[] array = new double[size];
		for (int i = 0; i < array.length; i++) {
			System.out.println("�������� �Է��ϼ���");
			array[i] = scan.nextDouble();
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println("�迭[" + i + "]�� ����" + array[i] + "�Դϴ�");
		}
	}
}
