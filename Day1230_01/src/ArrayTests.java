
public class ArrayTests {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 7, 9, 4, 6, 5, 10, 8 };
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println(max);
	}
}
