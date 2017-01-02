
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 7, 9, 4, 6, 5, 10, 8 };
		int tmp = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
