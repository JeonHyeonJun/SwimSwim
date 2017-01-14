import java.util.*;

public class AttendanceSystem {
	private static Scanner scan = new Scanner(System.in);
	// static List<Subject> sub = new ArrayList<Subject>();
	// static List<Subject> sub2 = new ArrayList<Subject>();

	public static void main(String[] args) {
		int num = 0;
		int fail = 0;
		boolean run = true;
		final int ATTENDENCE = 15;
		Student[] st = new Student[3];

		// sub.add(new Subject(1,"철학",0));
		// sub.add(new Subject(2,"물리학",0));
		// sub.add(new Subject(3,"기계학",0));
		//
		// sub2.add(new Subject(3,"기계학",0));

		st[0] = new Student("id1", "ps1", "김모범");
		st[1] = new Student("id2", "ps2", "김불량");
		st[2] = new Student("id3", "ps3", "김평범");
		// st[0].getSubject().set(0, "sd");

		st[0].add(1, "철학", 0, 3);
		st[0].add(2, "물리학", 0, 2);
		st[1].add(3, "과학", 0, 4);
		st[1].add(4, "기하학", 0, 4);
		st[2].add(5, "역학", 0, 1);
		
//		st[0].setnum(1, 2); 출석번호변경

		while (run) {
			try {
				System.out.println("-------------------");
				System.out.println("전자출결시스템");
				System.out.println("-------------------");
				System.out.println("1.학생 | 2.교수 | 3.종료");
				System.out.println("-------------------");
				System.out.print("선택> ");
				int select = scan.nextInt();

				// 학생로그인
				if (select == 1) {
					boolean login = false;
					boolean subselect = false;
					System.out.print("id: ");
					String b = scan.next();
					System.out.print("passward: ");
					String c = scan.next();

					// id,ps일치
					for (int i = 0; i < 3; i++) {
						if (b.equals(st[i].getId()) && c.equals(st[i].getPassward())) {
							System.out.println("로그인성공");
							login = true;
							
							// 강의목록+강의선택
								System.out.println(st[i].getSubject());
								System.out.println("-------------------");
								System.out.print("강의번호입력> ");
								select = scan.nextInt();
							
								//출석번호입력
							for (int k = 0; k < st[i].getSubject().size(); k++)
								if (select == st[i].getSubject().get(k).getSubjectcode()) {
									subselect = true;
									
									while (fail < 3 && run) {
											System.out.print("출석번호> ");
											num = scan.nextInt();
										
											//출석성공
										if (num !=0 && num == st[i].getSubject().get(k).getNumber()) {
											System.out.println("출석이 완료되었습니다.");
											int tmp = st[i].getSubject().get(k).setAttendance(st[i].getSubject().get(k).getAttendance() + 1);
											System.out.println("출석률: " + tmp + "/" + ATTENDENCE);
											run = false;
											
											//출석실패
										} else {
											fail++;
											System.out.println("출석번호가 일치하지않습니다. " +fail+"번실패");
										}
									} // 출석 while
									fail = 0;	//출석실패횟수 초기화
								} // 강의선택성공
							if (subselect == false) {
								System.out.println("수강중인 강의가 아닙니다.");
							}
						}
					} // 맨위for

					// id,ps불일치
					if (login == false)
						System.out.println("id 또는 password가 일치하지 않습니다.");

					// 교수
				} else if (select == 2) {

					// 종료
				} else if (select == 3) {
					run = false;

					// 그외번호입력
				} else
					System.out.println("올바른 번호를 선택하세요.");

				// 선택할때 문자예외처리
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.");
				scan.next();
			}
		} // 전체while
	}// main
}// AttendanceSystem
