import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
	private static List<Account> accountArray = new ArrayList<Account>();
	private static Scanner scanner = new Scanner(System.in);
//	private static int use = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.이체 | 6.종료 | 0.삭제");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
//				if (use < accountArray.length)
					createAccount();
//				else
//					System.out.println("더이상 계좌 못만듦");
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				trans();
			} else if (selectNo == 6) {
				run = false;
			} else if (selectNo == 0) {
				delete();
			}
		}
		System.out.println("프로그램 종료");
	}

	// 계좌생성
	private static void createAccount() {
		System.out.println(accountArray.size());
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");

		System.out.print("계좌번호: ");
		String a = scanner.next();

		if (findAccount(a) != null) {
			System.out.println("이미 존재하는 계좌번호임다");
			return;
		}

		System.out.print("계좌주: ");
		String b = scanner.next();
		System.out.print("초기입금액: ");
		int c = scanner.nextInt();
		if(c<Account.getMIN_BALANCE() || c>Account.getMAX_BALANCE()){
			System.out.println("1회 입금한도초과 (0~1000000)");
			return;
		}
		accountArray.add(new Account(a,b,c));
		System.out.println("결과: 계좌가 생성되었습니다.");
//		use++;
	}

	// 계좌목록
	private static void accountList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");

		for(int i=0; i<accountArray.size(); i++)
			System.out.println(accountArray.get(i));
	}

	// 예금
	private static void deposit() {
		System.out.println("--------");
		System.out.println("예금");
		System.out.println("--------");

		System.out.print("계좌번호: ");
		String a = scanner.next();
		if (findAccount(a) != null) {
			System.out.print("예금액: ");
			int b = scanner.nextInt();
			findAccount(a).setBalance(findAccount(a).getBalance() + b);
			System.out.println("결과: 예금이 성공되었습니다.");
		} else
			System.out.println("존재안함");
	}

	// 출금
	private static void withdraw() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");

		System.out.print("계좌번호: ");
		String a = scanner.next();
		if (findAccount(a) != null) {
			System.out.print("출금액: ");
			int b = scanner.nextInt();

			if (findAccount(a).getBalance() - b >= 0) {
				findAccount(a).setBalance(findAccount(a).getBalance() - b);
				System.out.println("결과: 출금이 성공되었습니다.");
			} else
				System.out.println("니 돈없다");
		} else
			System.out.println("존재안함");
	}

	// 이체
	private static void trans() {
		System.out.println("--------");
		System.out.println("이체");
		System.out.println("--------");

		System.out.print("출금계좌입력 ");
		String a = scanner.next();
		if (findAccount(a) == null) {
			System.out.println("존재안함");
			return;
		}

		System.out.print("입금계좌입력 ");
		String b = scanner.next();
		if (findAccount(b) == null) {
			System.out.println("존재안함");
			return;
		}

		System.out.print("금액 ");
		int c = scanner.nextInt();
		if (findAccount(a).getBalance() - c >= 0) {
			findAccount(a).setBalance(findAccount(a).getBalance() - c);
			findAccount(b).setBalance(findAccount(b).getBalance() + c);
			System.out.println("완료");
		} else
			System.out.println("니 돈없다");
	}

	//삭제
	private static void delete(){
		System.out.println("--------");
		System.out.println("삭제");
		System.out.println("--------");
		
		System.out.print("계좌번호입력 ");
		String a = scanner.next();
		if(findAccount(a)!=null)
			deleteAccount(a);
		else
			System.out.println("존재안함");
	}
	
	private static void deleteAccount(String ano){
		for(int i =0; i<accountArray.size(); i++){
			if(accountArray.get(i).getAno().equals(ano))
			{
				accountArray.remove(i);
				System.out.println("삭제완료");
				return;
			}
		}
	}
	
	//중복확인
	private static Account findAccount(String ano) {

		for (int i = 0; i < accountArray.size(); i++) {
			if (accountArray.get(i).getAno().equals(ano)) {
				return accountArray.get(i);
			}
		}
		return null;
	}
}
