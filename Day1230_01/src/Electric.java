import java.util.Scanner;

public class Electric {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int use;
		final double[] plus = { 60.7, 125.9, 187.9, 280.6, 417.7, 709.5 };
		final int[] start = { 410, 910, 1600, 3850, 7300, 12940 };

		System.out.print("전기사용량을 입력하세요 : ");
		use = scan.nextInt();

//		int q = (use - 1) / 100;
//		double result = 0;
//
//		if (q >= 5) {
//			result = start[5];
//			for (int i = 0; i < 6; i++) {
//				result += 100 * plus[i];
//			}
//			result += (use - 5 * 100) * plus[5];
//		} 
//		else {
//			result = start[q];
//			for (int i = 0; i < q; i++) {
//				result += 100 * plus[i];
//			}
//			result += (use - q * 100) * plus[q];
//		}
		

		int i= 0;
		double result = 0;
		
		while(true){
			if(use > 100 && i<5){
				result += plus[i] * 100;
				i++;
				use -= 100;
			}
			else{
				result += plus[i] * use +plus[i];
				break;
			}
		}

		
		System.out.println("누진제는" + result + "입니다");
	}
}

// switch (q) {
// case 0:
// result = 410 + (use - 0*100) * plus[0];
// break;
// case 1:
// result = 910 + 100 * plus[0] + (use - 1*100) * plus[1];
// break;
// case 2:
// result = 1600 + 100 * plus[0] + 100 * plus[1] + (use - 2*100) * plus[2];
// break;
// case 3:
// result = 3850 + 100 * plus[0] + 100 * plus[1] + 100 * plus[2] + (use - 3*100) * plus[3];
// break;
// case 4:
// result = 7300 + 100 * plus[0] + 100 * plus[1] + 100 * plus[2] + 100 * plus[3] + (use - 4*100) *
// plus[4];
// break;
// default:
// result = 12940 + 100 * plus[0] + 100 * plus[1] + 100 * plus[2] + 100 * plus[3] + 100 * plus[4] + (use -
// 5*100) * plus[5];
// break;