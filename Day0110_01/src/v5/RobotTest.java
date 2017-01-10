package v5;

public class RobotTest {
	public static void main(String[] args) {
		PunchAttack pa = new PunchAttack();			//공격 둘과 이동 둘간의 상관관계가없음
		MissileAttack ma = new MissileAttack();
		WalkingMove wm = new WalkingMove();
		FlyingMove fm = new FlyingMove();
		
		Robot[] rb = new Robot[3];
		for(int i=0; i<rb.length; i++)
			rb[i] = new Robot();
		rb[0].setAttack(pa);
		rb[0].setMove(fm);
		rb[1].setAttack(ma);
		rb[1].setMove(wm);
		rb[2].setAttack(pa);
		rb[2].setMove(wm);
		
		for(int i=0; i<rb.length; i++){
			rb[i].fight();
			System.out.println("----------------");
		}
	}
}
