import java.util.Scanner;

public class DaysInMonth {
	public static void main(String[] args) {
		int month;
		int year=2009;
		int days =0;
		
		System.out.println("그래. 몇월의 일수가 궁금하느냐?");
		Scanner scan = new Scanner(System.in);
		month = scan.nextInt();
		
		
		switch (month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days =31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days=30;
			break;
		case 2:
			if((year%4==0 && year%100!=0) || year%400==0)
				days=29;
			else
				days=28;
			break;
			default:
				System.out.println("그런날은 존재하지 않네!");
				break;
		}
		System.out.println(month+"월의 일 수는 "+days+"일이네 껄껄껄");
	}
}
