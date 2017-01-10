package v3;

public class SunGuard extends Robot{
	private WalkingMove move = new WalkingMove();
	private MissileAttack attack = new MissileAttack();
	
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
