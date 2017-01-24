import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentDao st = StudentDao.getInstance();
		boolean run = true;
		
		while(run){
			System.out.println("======================");
			System.out.println("1.추가|2.수정|3.삭제|4.종료");
			System.out.println("======================");
			System.out.print("선택> ");
			int select = scan.nextInt();
			
			if(select == 1){
				System.out.print("이름 ");
				String name = scan.next();
				System.out.print("나이 ");
				int age = scan.nextInt();
				System.out.print("점수 ");
				int score = scan.nextInt();
				st.insert(name,age,score);
				
			} else if (select == 2){
				System.out.print("학번");
				int s_id = scan.nextInt();
				System.out.print("이름 ");
				String name = scan.next();
				System.out.print("나이 ");
				int age = scan.nextInt();
				System.out.print("점수 ");
				int score = scan.nextInt();
				st.update(s_id,name,age,score);
			
			} else if (select == 3){
				System.out.print("학번 ");
				int s_id = scan.nextInt();
				st.delete(s_id);
				
			} else if (select == 4){
				run = false;
				st.close();
			}
		}
	}
}
