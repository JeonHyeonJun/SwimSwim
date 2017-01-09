
public class Novel extends Book{
//	private int money;
	static final int DAY = 500;
	
	public Novel(String i, String w, String p, String t){
		super(i,w,p,t);
		System.out.println("ISBN: " +i+ " 저자: "+w+ " 출판사: " +p+ " 제목: " +t);
	}
	public int day(int d){
//		money = d*DAY;
		return d*DAY;
	}
}
