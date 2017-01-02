
public class Numbers {
	public static void main(String[] args) {
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length; i++)	//numbers.length: numbers의길이, numbers의 크기는 현재5이므로 5라고 보면된다
			numbers[i] = (int) (Math.random() * 1000);
		for (int value : numbers)		//for-each루프: numbers집합의 있는 데이터를 value에 하나씩 옮긴다
			System.out.println(value);	//value로 옮긴 데이터를 출력
	}
}
