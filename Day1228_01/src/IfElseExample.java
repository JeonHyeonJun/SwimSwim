
public class IfElseExample {
	public static void main(String[] args) {
		int score = 75;

		if (score >= 90) {
			System.out.println("A����Դϴ�!");
			System.out.println("�Ҹ����� ��Ƽ����!");
		} else if (score >= 80) {
			System.out.println("B����");
			System.out.println("��ȣ");
		} else if (score >= 70) {
			System.out.println("C��");
			System.out.println("C.Va");
		} else if (score >= 60) {
			System.out.println("D");
			System.out.println("�̰͵� �����غ�����");
		} else {
			System.out.println("FFFFFFFFF");
			System.out.println("�ڻ�");
		}
	}
}
