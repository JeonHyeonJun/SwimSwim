
public class Student {
	private String name;
	private Score score;
	
	public Student(){
		name = "이름없음";
		score = new Score();
	}
	public Student(String name, Score score){
		this.name = name;
		this.score = new Score(score.getMath(),score.getKor(),score.getEng());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score.setMath(score.getMath());
		this.score.setKor(score.getKor());
		this.score.setEng(score.getEng());
		
//		this.score = score;
	}
	
	public String toString(){
		if(score.getEng()+score.getKor()+score.getMath()>300)
			System.out.println(name+"의 성적은 주작입니다!!!");
		return "이름: " +name+ " 성적[ 수학: "+score.getMath()+" 국어: "+score.getKor()+" 영어: "+score.getEng()+"]";
		
	}
	
	
}
