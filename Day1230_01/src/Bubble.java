
public class Bubble {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 7, 9, 4, 6, 5, 10, 8 };
		int tmp = 0;
		boolean sw = false;

		for (int i = 0; i < arr.length && sw == false; i++) {
			sw = true;
			for (int k = 0; k < arr.length; k++)
				System.out.print(arr[k] + " ");
			System.out.println(i + "¹øÈ¸Àü");

			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					sw = false;
				}
			}
		}
	}
}
