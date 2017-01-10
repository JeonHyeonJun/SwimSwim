package v4;

public class TaekwonV extends Robot{
	private PunchAttack attack;		//외부에서 private인 펀치어택과 플라잉무브 객체 넣어주려면 생성자나 설정자를 통해 넣어준다
	private FlyingMove move;		//외부에서 객체를 만들어서 넣어주는 작업을 의존성 주입, 방법은 생성자주입과 설정자주입
	
	public void setAttack(PunchAttack attack) {
		this.attack = attack;
	}

	public void setMove(FlyingMove move) {
		this.move = move;
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
