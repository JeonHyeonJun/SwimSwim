
public class Poet extends Book{
	static final int DAY = 300;
	
	public Poet(String i, String w, String p, String t){
		super(i,w,p,t);
		System.out.println("ISBN: " +i+ " 저자: "+w+ " 출판사: " +p+ " 제목: " +t);
	}
	public int day(int d){
		return d*DAY;
	}
}
