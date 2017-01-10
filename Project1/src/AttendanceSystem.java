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
		
		st[0] = new Student("id1","ps1","김모범",6);
		st[1] = new Student("id2","ps2","김불량",1);
		st[2] = new Student("id3","ps3","김평범",3);
		pr[0] = new Professor("id4","ps4","김교수");
		pr[1] = new Professor("id5","ps5","박교수");
		
		st[0].setLecture(p);
		st[1].setLecture(e);
		st[2].setLecture(j);
		pr[0].setLecture(p);
		pr[1].setLecture(e);
		
		System.out.println("전자출결시스템");
		System.out.println("1.학생 | 2.교수 | 3.종료");
		int a = scan.nextInt();
		System.out.print("id: ");
		String b = scan.next();
		System.out.print("passward: ");
		String c = scan.next();
		if(a==1){
		for(int i=0; i<3; i++){
			if(b.equals(st[i].getId()) && c.equals(st[i].getPassward()))
					System.out.println("로그인성공");		
		}
		} else {
			for(int i=0; i<2; i++){
				if(b.equals(pr[i].getId()) && c.equals(pr[i].getPassward()))
						System.out.println("로그인성공");
			}
		}
	
	}
}
