import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountTest {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountDao acc = AccountDao.getInstance();

		
			
			boolean run = true;

//			insert("1","2",3);
//			update("111","zz",777);
			while (run) {
				System.out.println("===============================");
				System.out.println("1.계좌추가 2.계좌수정 3.계좌삭제 4.조회 5.종료");
				System.out.println("===============================");
				System.out.print("선택> ");
				int select = scan.nextInt();

				if (select == 1) {
					System.out.print("계좌번호 ");
					String ano = scan.next();
					System.out.print("계좌주 ");
					String owner = scan.next();
					System.out.print("금액 ");
					int balance = scan.nextInt();
					acc.insert(ano, owner, balance);
				} else if (select == 2) {
					System.out.print("계좌주 ");
					String owner = scan.next();
					System.out.print("금액 ");
					int balance = scan.nextInt();
					System.out.print("계좌번호 ");
					String ano = scan.next();
					acc.update(ano, owner, balance);
				} else if (select == 3) {
					System.out.print("계좌번호 ");
					String ano = scan.next();
					acc.delete(ano);
				} else if (select == 4) {
//					for(int i=0; i<acc.selectAll().size(); i++)
//						System.out.println(acc.selectAll().get(i));
					acc.selectAll();
				} else if (select == 5) {
					System.out.println("종료합니다");
					run = false;
				}
			}

	}

	
}
