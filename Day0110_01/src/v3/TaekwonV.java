package v3;

public class TaekwonV extends Robot{
	//전략패턴 strategy pattern
	private FlyingMove move = new FlyingMove();
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
