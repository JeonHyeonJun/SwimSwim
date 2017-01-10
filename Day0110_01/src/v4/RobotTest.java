package v4;

public class RobotTest {
	public static void main(String[] args) {
		PunchAttack pa = new PunchAttack();
		MissileAttack ma = new MissileAttack();
		WalkingMove wm = new WalkingMove();
		FlyingMove fm = new FlyingMove();
		
		TaekwonV t = new TaekwonV();
		SunGuard s = new SunGuard();
		MazingaZ m = new MazingaZ();
		t.setAttack(pa);
		t.setMove(fm);
		s.setAttack(ma);
		s.setMove(wm);
		m.setAttack(pa);
		m.setMove(wm);
		t.attack();
	}
}
