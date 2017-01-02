
public class ArrayGob {
	public static void main(String[] args) {
		final int SIZE = 3;
		int[][] array1 = { { 3, 1, 2 }, { 2, 4, 4 }, { 1, 2, 3 } };
		int[][] array2 = { { 4, 5, 3 }, { 6, 7, 2 }, { 2, 1, 3 } };
		int[][] gob = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				for (int n = 0; n < SIZE; n++)
					gob[i][j] += array1[i][n] * array2[n][j];

				// gob[i][j] = array1[i][0] * array2[0][j] + array1[i][1] * array2[1][j] + array1[i][2] * array2[2][j];
				System.out.print(gob[i][j] + " ");
			}
			System.out.println();
		}
	}
}

// 00 = 00*00+01*10
// 01 = 00*01+01*11
// 10 = 10*00+11*10
// 11 = 10*01+11*11

// 00 = 00*00+01*10+02*20
// 01 = 00*01+01*11+02*21
// 02 = 00*02+01*12+02*22
// 10 = 10*00+11*10+12*20
// 11 = 10*01+11*11+12*21
// 12 = 10*02+11*12+12*22
// 20 = 20*00+21*10+22*20
// 21 = 20*01+21*11+22*21
// 22 = 20*02+21*12+22*22