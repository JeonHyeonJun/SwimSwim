package v4;

public class MazingaZ extends Robot{
	private WalkingMove move;
	private PunchAttack attack;
	
	public void setMove(WalkingMove move) {
		this.move = move;
	}

	public void setAttack(PunchAttack attack) {
		this.attack = attack;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		move.move();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		attack.attack();
	}

}
