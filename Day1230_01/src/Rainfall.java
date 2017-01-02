import java.util.Scanner;

public class Rainfall {
	public static void main(String[] args) {
		final int YEARS = 3;
		final int QUARTERS = 4;
		double[][] rain = new double[YEARS][QUARTERS];
		Scanner scan = new Scanner(System.in);
		
		for(int y=0;y<YEARS;y++){
			for(int q=0;q<QUARTERS;q++){
				System.out.print(y+"���⵵"+q+"�б� ������ : ");
				rain[y][q] = scan.nextDouble();
			}
		}
		for(int y=0;y<YEARS;y++){
			double total=0.0;
			for(int q=0; q<QUARTERS;q++){
				total+=rain[y][q];
			}
			System.out.println(y+"���⵵ �������� "+total);
		}
	}
}
