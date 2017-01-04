
public class Student {
	private String name;
	private Score score;
	
	public Student(){
		name = "�̸�����";
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
			System.out.println(name+"�� ������ �����Դϴ�!!!");
		return "�̸�: " +name+ " ����[ ����: "+score.getMath()+" ����: "+score.getKor()+" ����: "+score.getEng()+"]";
		
	}
	
	
}
