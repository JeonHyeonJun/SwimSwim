import java.util.Scanner;

//StudentTestŬ������ �����Ͽ� main�Լ��� ����� Student��� �ڷ����� �����Ͽ� �̸�,�����,���м���,������� ������ �� �ֵ��� ���¸� �����ϰ� ��ձ��ϴ� ��ɰ� �������ϴ� ����� ����
//StudentTest�� main�Լ����� Student�ڷ����� �̿��� �ΰ��� Student��ü�� ���� �� �� ���¿� ������ ���� �Է��Ͽ� �� ���°�,��հ�,�������� ���

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
		return "�̸� : " +name+ " \t���� : " +korean+ " \t���� : " +math+ " \t���� : " +english+ "\n���� : " +sum+ " \t��� : "+average;
	}
	public void start(){
		name = naming("�̸��Է� : ");
		korean = score(name+ "�� ���������Է� : ");
		math = score(name+ "�� ���������Է� : ");
		english = score(name+ "�� ���������Է� : ");
		result();
		System.out.println(toString());
		//		System.out.println("���� : " +sum+ "\t��� : " +average);
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
