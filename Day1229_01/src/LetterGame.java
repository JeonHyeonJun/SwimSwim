import java.util.Scanner;

public class LetterGame {
	public static void main(String[] args) {
		int answer=59;
		int guess;
		int tries=0;
		Scanner scan= new Scanner(System.in);
		
		do{
			System.out.print("���������纸�ƶ�");
			guess = scan.nextInt();
			tries++;
			
			if(guess>answer)
				System.out.println("�����ϴ� �����");
			if(guess<answer)
				System.out.println("�����ϴ� ������");
		}
		while(guess!=answer);
		
		System.out.println("�����մϴ�. �õ�Ƚ�� : "+tries);
	}
}
