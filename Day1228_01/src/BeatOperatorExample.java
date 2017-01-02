
public class BeatOperatorExample {
	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		int x = 0x0fff;
		int y = 0xfff0;

		System.out.println(a & b);
		System.out.println(a | b);
		System.out.println(a ^ b);
		System.out.printf("%x\n", (x & y));
		System.out.printf("%x\n", (x | y));
		System.out.printf("%x\n", (x ^ y));
		System.out.printf("%x\n", ~x);
		System.out.printf("%x\n", (x << 4));
		System.out.printf("%x\n", (x >> 4));

	}
}
