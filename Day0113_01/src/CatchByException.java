
public class CatchByException {
	public static void main(String[] args) {
		try {
			String data1 = args[0];
			String data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" +result);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("부족");
			System.out.println("방법");
			System.out.println("java CatchBy ~~");
		} catch(NumberFormatException e) {
			System.out.println("변환안돼");
		} finally {
			System.out.println("다시실행");
		}
	}
}
