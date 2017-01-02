
public class Uclid {
	public static void main(String[] args) {
		int x= 6;
		int y= 9;
		int r;
		
		while(y!=0){
			r=x%y;
			x=y;
			y=r;
		}
		System.out.println(x);
	}
}
