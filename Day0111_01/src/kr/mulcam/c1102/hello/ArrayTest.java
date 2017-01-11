package kr.mulcam.c1102.hello;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		int[] array = {9,4,5,6,2,1};
		Arrays.sort(array);
		printArray(array);
		System.out.println(Arrays.binarySearch(array, 9));
		Arrays.fill(array, 8);
		printArray(array);
	}
	
	private static void printArray(int[] array){
		System.out.print("[");
		for(int i=0; i<array.length; i++)
			System.out.print(array[i]+" ");
		System.out.println("]");
	}
}
