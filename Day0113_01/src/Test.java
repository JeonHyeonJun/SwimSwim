import java.util.Scanner;

//크기 10인 베열에 11번째에다가 0넣고 에러안내기
public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int array[] = new int[10];

		try{
			array[11] = 0;
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("배열범위초과");
		}
	}
}
