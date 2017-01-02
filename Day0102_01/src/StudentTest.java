import java.util.Scanner;

//StudentTest클래스를 생성하여 main함수를 만들고 Student라는 자료형을 정의하여 이름,국어성적,수학성적,영어성적을 저장할 수 있도록 상태를 정의하고 평균구하는 기능과 총점구하는 기능을 정의
//StudentTest의 main함수에서 Student자료형을 이용해 두개의 Student객체를 생성 후 각 상태에 임의의 값을 입력하여 각 상태값,평균값,총점들을 출력

class Student{
	String name;
	int sum;
	double average;
	int korean;
	int math;
	int english;
	
	public String naming(String i){
		System.out.print(i);
		Scanner s= new Scanner(System.in);
		return s.nextLine();
	}
	public int score(String j){
		System.out.print(j);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	public void result(){
		sum = korean+math+english;
		average = (double)sum/3;
	}
	public String toString(){
		return "이름 : " +name+ " \t국어 : " +korean+ " \t수학 : " +math+ " \t영어 : " +english+ "\n총점 : " +sum+ " \t평균 : "+average;
	}
	public void start(){
		name = naming("이름입력 : ");
		korean = score(name+ "의 국어점수입력 : ");
		math = score(name+ "의 수학점수입력 : ");
		english = score(name+ "의 영어점수입력 : ");
		result();
		System.out.println(toString());
		//		System.out.println("총점 : " +sum+ "\t평균 : " +average);
	}
}

public class StudentTest {
	public static void main(String[] args) {
		Student s1= new Student();
		s1.start();
		Student s2= new Student();
		s2.start();
	}
}
