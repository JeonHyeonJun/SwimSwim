package v5;

public class Robot {
	private Attack attack;
	private Move move;
	private String name;
	
	public void setAttack(Attack attack) {
		this.attack = attack;
	}
	public void setMove(Move move) {
		this.move = move;
	}
	
	public void fight(){
		System.out.println("니가 그렇게 따움을 잘해?");
		move.move();
		attack.attack();
		System.out.println("옥땅으로 따라와");
	}
}
