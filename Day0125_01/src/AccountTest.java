import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		AccountService as = new AccountService();
		while (run) {
			System.out.println("--------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.이체|6.삭제|7.종료");
			System.out.println("--------------------------------------");
			System.out.print("선택> ");
			int selectNo = scan.nextInt();
			if (selectNo == 1) {
				System.out.println("--------------");
				System.out.println("계좌 생성");
				System.out.println("--------------");

				System.out.print("계좌번호 : ");
				String ano = scan.next();
				System.out.print("계좌주 : ");
				String name = scan.next();
				System.out.print("초기 입금액 : ");
				int bal = scan.nextInt();

				boolean result = as.createAccount(ano, name, bal);
				if (result)
					System.out.println("계좌생성이 성공했습니다");
				else
					System.out.println("이미 존재하는 계좌번호 입니다");
				
			} else if (selectNo == 2) {
				System.out.println("--------------");
				System.out.println("계좌목록");
				System.out.println("--------------");
				List<Account> list = as.accountList();
				for (Account c : list)
					System.out.println(c);
				
			} else if (selectNo == 3) {
				System.out.println("--------------");
				System.out.println("예금");
				System.out.println("--------------");
				System.out.print("계좌번호 : ");
				String ano = scan.next();
				System.out.print("입금액 : ");
				int bal = scan.nextInt();
				int result = as.deposit(ano, bal);
				if (result == 1)
					System.out.println("예금성공");
				else if (result == 2)
					System.out.println("계좌가 존재하지 않습니다");
				else if (result == 3)
					System.out.println("금액이 음수입니다");
				
			} else if (selectNo == 4) {
				System.out.println("--------------");
				System.out.println("출금");
				System.out.println("--------------");
				System.out.print("계좌번호 : ");
				String ano = scan.next();
				System.out.print("출금액 : ");
				int bal = scan.nextInt();

				int result = as.withdraw(ano, bal);
				if (result == 1)
					System.out.println("출금성공");
				else if (result == 2)
					System.out.println("계좌가 존재하지 않습니다");
				else if (result == 3)
					System.out.println("금액이 음수입니다");
				else if (result == 4)
					System.out.println("돈없네ㅋ?");
				
			} else if (selectNo == 5) {
				System.out.println("--------------");
				System.out.println("이체");
				System.out.println("--------------");
				System.out.print("이체할 계좌 번호 : ");
				String ano = scan.next();
				System.out.print("이체 받을 계좌 번호 : ");
				String ano2 = scan.next();
				System.out.print("출금액 : ");
				int bal = scan.nextInt();
				int result = as.transit(ano, ano2, bal);
				if (result == 1)
					System.out.println("이체성공");
				else if (result == 2)
					System.out.println("계좌가 존재하지 않습니다");
				else if (result == 3)
					System.out.println("금액이 음수입니다");
				else if (result == 4)
					System.out.println("돈없네ㅋ?");
				
			} else if (selectNo == 6) {
				System.out.println("--------------");
				System.out.println("삭제");
				System.out.println("--------------");
				System.out.print("계좌번호 : ");
				String ano = scan.next();
				int result = as.delete(ano);
				if (result == 1)
					System.out.println("삭제성공");
				else if (result == 2)
					System.out.println("없는계좌네여");
				
			} else if (selectNo == 7) {
				run = false;
			}
		}

	}

//	private static boolean createAccount(String ano, String name, int bal) {
//
//		Account a = ad.SelectOne(ano);
//		if (a != null) {
//			return false;
//		} else {
//			ad.InsertAccount(ano, name, bal);
//			return true;
//		}
//	}
//
//	private static List<Account> accountList() {
//
//		List<Account> temp = ad.SelectAll();
//		return temp;
//	}
//
//	private static int deposit(String ano, int bal) {
//
//		Account temp = ad.SelectOne(ano);
//		if (temp == null) {
//			return 2;
//		} else {
//
//			if (bal > 0) {
//				ad.UpdateAccount(temp.getAno(), temp.getName(), temp.getBal() + bal);
//				return 1;
//			} else
//				return 3;
//		}
//	}
//
//	private static int withdraw(String ano, int bal) {
//
//		Account temp = ad.SelectOne(ano);
//		if (temp == null) {
//			return 2;
//		} else {
//			if (bal < 0)
//				return 3;
//			else if (temp.getBal() < bal)
//				return 4;
//			else {
//				ad.UpdateAccount(temp.getAno(), temp.getName(), temp.getBal() - bal);
//				return 1;
//			}
//		}
//	}
//
//	private static int delete(String ano) {
//
//		Account a = ad.SelectOne(ano);
//		if (a != null) {
//			ad.DeleteAccount(ano);
//			return 1;
//		} else {
//			return 2;
//		}
//	}
//
//	private static int transit(String ano, String ano2, int bal) {
//
//		Account temp = ad.SelectOne(ano);
//
//		Account temp2 = ad.SelectOne(ano2);
//
//		if (temp == null || temp2 == null) {
//			return 2;
//		} else {
//			if (bal < 0)
//				return 3;
//			else if (temp.getBal() < bal)
//				return 4;
//			else {
//				ad.UpdateAccount(temp.getAno(), temp.getName(), temp.getBal() - bal);
//				ad.UpdateAccount(temp2.getAno(), temp2.getName(), temp2.getBal() + bal);
//				return 1;
//			}
//
//		}
//	}

}
