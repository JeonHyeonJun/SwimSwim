import java.util.Scanner;
public class CircleArea {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double radius;
		double area;
		
		System.out.print("�������Է� : ");
		radius = scan.nextDouble();
		
		area = 3.14*radius*radius;
		System.out.println(area);
	}
}
