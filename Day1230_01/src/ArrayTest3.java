//�ϳ��ǹ迭�� �ٸ� �迭�� �����ϴ� �ݺ� ������ �ۼ�
public class ArrayTest3 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < array.length; i++) {
			array[i] = array[0];
		}
		for (int i = 0; i < array.length; i++)
			System.out.println("�迭[" + i + "]�� ����" + array[i] + "�Դϴ�");
	}
}
