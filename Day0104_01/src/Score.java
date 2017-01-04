
public class Score {
	private int math;
	private int kor;
	private int eng;
	
	public Score(){
		math=kor=eng=0;
	}
	public Score(int math, int kor, int eng){
		this.math = math;
		this.kor = kor;
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		if(math>=0 && math<=100)
		this.math = math;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		if(kor>=0 && kor<=100)
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		if(eng>=0 && eng<=100)
		this.eng = eng;
	}
	
	public String toString(){
		return "수학: " +math+ " 국어: " +kor+ " 영어: " +eng;
	}
	
	
}
