
public class ArraySum {
	public static void main(String[] args) {
		final int SIZE = 3;
		int[][] array1 = { { 3, 1, 2 }, { 2, 4, 4 }, { 1, 2, 3 } };
		int[][] array2 = { { 4, 5, 3 }, { 6, 7, 2 }, { 2, 1, 3 } };
		int[][] sum = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				sum[i][j] = array1[i][j] + array2[i][j];
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}

	}
}
