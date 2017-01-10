package v3;

public class RobotTest {
	public static void main(String[] args) {
		Robot r1 = new TaekwonV();
		Robot r2 = new SunGuard();
		Robot r3 = new MazingaZ();
		
		r1.fight();
		System.out.println("-----------");
		r2.fight();
		System.out.println("-----------");
		r3.fight();
	}
}
