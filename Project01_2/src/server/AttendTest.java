package server;

import java.util.Scanner;
 
public class AttendTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AttendService as = new AttendService();
		boolean run = true;
		int fail = 1;
		
		while (run) {
			
			System.out.println("-------------------");
			System.out.println("전자출결시스템");
			System.out.println("-------------------");
			System.out.println("1.학생 | 2.교수 | 3.종료");
			System.out.println("-------------------");
			System.out.print("선택> ");
			int select = scan.nextInt();
			
			//학생
			if (select == 1) {
				System.out.print("id: ");
				String id = scan.next();
				System.out.print("password: ");
				String ps = scan.next();

				boolean s_result = as.st_login(id, ps);
				if (s_result) {
					System.out.println("로그인성공");
					for (int i = 0; i < as.st_subjectlist(id, ps).size(); i++)
						System.out.println(as.st_subjectlist(id, ps).get(i));
					System.out.print("강의번호입력> ");
					String a = scan.next();

					s_result = as.st_subjectselect(id, ps, a);
					if (s_result) {
						while (run) {
							System.out.print("출석번호입력> ");
							int num = scan.nextInt();

							int result2 = as.st_attend(a, num, fail);
							if (result2 == 1) {
								System.out.println("출석성공");
								int success = as.attendsuccess(id, ps, a);
								System.out.println(success+"회 출석완료");
								run = false;
							} else if (result2 == 2) {
								System.out.println("출석"+fail+"회 실패");
								fail++;
							} else if (result2 == 3) {
								System.out.println("출석실패");
								run = false;
							}
						}
					} else
						System.out.println("올바른 강의번호를 입력해주세요");
				} else
					System.out.println("id 또는 password가 잘못되었습니다");
			}
			//교수
			else if (select == 2) {
				System.out.print("id: ");
				String id = scan.next();
				System.out.print("password: ");
				String ps = scan.next();

				boolean p_result = as.pr_login(id, ps);
				if (p_result) {
					System.out.println("로그인성공");
					for (int i = 0; i < as.pr_subjectlist(id, ps).size(); i++)
						System.out.println(as.pr_subjectlist(id, ps).get(i));
					System.out.print("강의번호입력> ");
					String a = scan.next();

					p_result = as.pr_subjectselect(id, ps, a);
					if (p_result) {
						System.out.println("출석번호는 "+as.pr_attend(a)+" 입니다");
					} else
						System.out.println("올바른 강의번호를 입력해주세요");
				} else
					System.out.println("id 또는 password가 잘못되었습니다");
			
			}
			//종료
			else if (select == 3) {
				System.out.println("종료");
				run = false;
			}

		} // while
	}// main
}
