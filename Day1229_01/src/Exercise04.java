import java.util.Scanner;

public class Exercise04 {
	public static void main(String[] args) {
		int x;
		int y;
		int sum=0;
		
		while(sum!=5){
			x = (int)(Math.random()*6)+1;
			y = (int)(Math.random()*6)+1;
			System.out.println("("+x+","+y+")");
			sum = x+y;
		}
	}
}
