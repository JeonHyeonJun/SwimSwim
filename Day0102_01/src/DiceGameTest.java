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
			System.out.println("�¾ҽ��ϴ�");
		else
			System.out.println("��");
	}
	public void startPlaying()
	{
		RollDice();
		System.out.println("������ "+diceFace);
		userGuess = getUserInput("������ �Է��ϼ��� : ");
		checkUserGuess();
	}
}

public class DiceGameTest {
	public static void main(String[] args) {
		DiceGame game = new DiceGame();
		game.startPlaying();
	}
}
