
public class Numbers {
	public static void main(String[] args) {
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length; i++)	//numbers.length: numbers�Ǳ���, numbers�� ũ��� ����5�̹Ƿ� 5��� ����ȴ�
			numbers[i] = (int) (Math.random() * 1000);
		for (int value : numbers)		//for-each����: numbers������ �ִ� �����͸� value�� �ϳ��� �ű��
			System.out.println(value);	//value�� �ű� �����͸� ���
	}
}
