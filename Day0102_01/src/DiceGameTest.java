import java.util.Scanner;

class DiceGame{
	 int diceFace;
	 int userGuess;
	
	private void RollDice()
	{
		diceFace = (int)(Math.random()*6)+1;
	}
	private int getUserInput(String prompt)
	{
		System.out.print(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	private void checkUserGuess()
	{
		if(diceFace == userGuess)
			System.out.println("맞았습니다");
		else
			System.out.println("땡");
	}
	public void startPlaying()
	{
		RollDice();
		System.out.println("정답은 "+diceFace);
		userGuess = getUserInput("예상값을 입력하세요 : ");
		checkUserGuess();
	}
}

public class DiceGameTest {
	public static void main(String[] args) {
		DiceGame game = new DiceGame();
		game.startPlaying();
	}
}
