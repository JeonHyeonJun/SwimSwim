package v4;

public class SunGuard extends Robot{
	private WalkingMove move;
	private MissileAttack attack;
	
	public void setMove(WalkingMove move) {
		this.move = move;
	}

	public void setAttack(MissileAttack attack) {
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
