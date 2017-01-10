package v4;	//리스코프치환원칙을 적용하여 멤버변수의 다형성을 넣을것이다 v5에서 ㅇㅇ

public class RobotTest {
	public static void main(String[] args) {
		PunchAttack pa = new PunchAttack();			//공격 둘과 이동 둘간의 상관관계가없음
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
