
public class ForExample2 {
	public static void main(String[] args) {
		int sum=0;
		int gob=1;
		
		for(int i=1;i<11;i++){
			sum = sum+i;
		}
		System.out.println("1부터10까지의 합 : "+sum);
		
		for(int i=2;i<11;i++){
			gob = gob*i;
		}
		System.out.println("1부터10까지의 곱 : "+gob);
	}
}	
