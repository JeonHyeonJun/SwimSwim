import java.util.Scanner;

public class Exercise07 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		int balance = 0;

		
		while(run){
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			int num;
			num = scan.nextInt();
			
			switch (num) {
			case 1:
				int i;
				System.out.print("예금액> ");
				i = scan.nextInt();
				balance += i; 
				break;
			case 2:
				System.out.print("출금액> ");
				i = scan.nextInt();
				balance -= i;
				break;
			case 3:
				System.out.println("잔고> "+balance);
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("다시선택하세요");
				break;
			}
			
		}
		System.out.println("프로그램 종료");
	}
}
