package v1;

public class RobotTest {
	public static void main(String[] args) {
		Robot r1 = new TaekwonV();
		Robot r2 = new SunGuard();
		
		r1.fight();
		r2.fight();
	}
}
