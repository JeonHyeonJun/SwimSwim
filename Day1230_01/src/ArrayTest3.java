//하나의배열을 다른 배열로 복사하는 반복 루프를 작성
public class ArrayTest3 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < array.length; i++) {
			array[i] = array[0];
		}
		for (int i = 0; i < array.length; i++)
			System.out.println("배열[" + i + "]의 값은" + array[i] + "입니다");
	}
}
