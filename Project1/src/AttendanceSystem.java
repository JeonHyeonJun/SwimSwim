import java.util.Scanner;

public class AttendanceSystem {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Student[] st = new Student[3];
		Professor[] pr = new Professor[2];
		Philosophy p = new Philosophy();
		English e = new English();
		Java j = new Java();

		int number;
		
		st[0] = new Student("id1","ps1","����",6);
		st[1] = new Student("id2","ps2","��ҷ�",1);
		st[2] = new Student("id3","ps3","�����",3);
		pr[0] = new Professor("id4","ps4","�豳��");
		pr[1] = new Professor("id5","ps5","�ڱ���");
		
		st[0].setLecture(p);
		st[1].setLecture(e);
		st[2].setLecture(j);
		pr[0].setLecture(p);
		pr[1].setLecture(e);
		
		System.out.println("�������ý���");
		System.out.println("1.�л� | 2.���� | 3.����");
		int a = scan.nextInt();
		System.out.print("id: ");
		String b = scan.next();
		System.out.print("passward: ");
		String c = scan.next();
		if(a==1){
		for(int i=0; i<3; i++){
			if(b.equals(st[i].getId()) && c.equals(st[i].getPassward()))
					System.out.println("�α��μ���");		
		}
		} else {
			for(int i=0; i<2; i++){
				if(b.equals(pr[i].getId()) && c.equals(pr[i].getPassward()))
						System.out.println("�α��μ���");
			}
		}
	
	}
}
