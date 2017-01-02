import java.util.Scanner;

public class LetterGame {
	public static void main(String[] args) {
		int answer=59;
		int guess;
		int tries=0;
		Scanner scan= new Scanner(System.in);
		
		do{
			System.out.print("접답을맞춰보아라");
			guess = scan.nextInt();
			tries++;
			
			if(guess>answer)
				System.out.println("높습니다 낮춰요");
			if(guess<answer)
				System.out.println("낮습니다 높여요");
		}
		while(guess!=answer);
		
		System.out.println("축하합니다. 시도횟수 : "+tries);
	}
}
