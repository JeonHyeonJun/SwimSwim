
public class StudentTest {
	public static void main(String[] args) {
		Score s = new Score(50, 70, 90);
		Student st1 = new Student();

		st1.setName("Hong");
		st1.setScore(s);
		System.out.println(s);
		System.out.println(st1);
		s.setMath(100);
		s.setKor(80);
		s.setEng(70);
		System.out.println(s);
		System.out.println(st1);
		
		Student st2 = new Student("Kim", s);
		System.out.println(s);
		System.out.println(st2);
		s.setMath(60);
		s.setKor(40);
		s.setEng(30);
		System.out.println(s);
		System.out.println(st2);
	}
}
