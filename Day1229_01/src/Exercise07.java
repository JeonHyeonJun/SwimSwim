import java.util.Scanner;

public class Exercise07 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		int balance = 0;

		
		while(run){
			System.out.println("----------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("----------------------------");
			System.out.print("����> ");
			int num;
			num = scan.nextInt();
			
			switch (num) {
			case 1:
				int i;
				System.out.print("���ݾ�> ");
				i = scan.nextInt();
				balance += i; 
				break;
			case 2:
				System.out.print("��ݾ�> ");
				i = scan.nextInt();
				balance -= i;
				break;
			case 3:
				System.out.println("�ܰ�> "+balance);
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("�ٽü����ϼ���");
				break;
			}
			
		}
		System.out.println("���α׷� ����");
	}
}
