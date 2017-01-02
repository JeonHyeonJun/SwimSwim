
public class Exercise05 {
	public static void main(String[] args) {
		int x;
		int y;

		
		
		for(x=1;x<11;x++){
			for(y=1;y<11;y++){
				int sum = (4*x)+(5*y);
				if(sum==60)
					System.out.println("("+x+","+y+")");
			}
		}
	}
}
