package v3;

public class MazingaZ extends Robot{
	private WalkingMove move = new WalkingMove();
	private PunchAttack attack = new PunchAttack();
	
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
