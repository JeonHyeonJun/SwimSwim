import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	private static int use = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.이체 | 6.종료 | 0.삭제");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				if (use < accountArray.length)
					createAccount();
				else
					System.out.println("계좌를 더이상 만들수 없습니다.");
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
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");

		System.out.print("계좌번호: ");
		String a = scanner.next();

		if (findAccount(a) != null) {
			System.out.println("이미 존재하는 계좌번호입니다.");
			return;
		}

		System.out.print("계좌주: ");
		String b = scanner.next();
		System.out.print("초기입금액: ");
		int c = scanner.nextInt();
		if(c<Account.getMIN_BALANCE() || c>Account.getMAX_BALANCE()){
			System.out.println("올바른 금액이 아닙니다.(0~1000000)");
			return;
		}
		accountArray[use] = new Account(a, b, c);
		System.out.println("결과: 계좌가 생성되었습니다.");
		use++;
	}

	// 계좌목록
	private static void accountList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");

		for (int i = 0; i < use; i++)
			System.out.println(accountArray[i]);
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
			System.out.println("계좌가 존재하지 않습니다.");
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
				System.out.println("잔액이 부족합니다.");
		} else
			System.out.println("계좌가 존재하지 않습니다.");
	}

	// 이체
	private static void trans() {
		System.out.println("--------");
		System.out.println("이체");
		System.out.println("--------");

		System.out.print("출금하실 계좌의 계좌번호를 입력하세요 ");
		String a = scanner.next();
		if (findAccount(a) == null) {
			System.out.println("잘못된 계좌번호입니다.");
			return;
		}

		System.out.print("받는 계좌의 계좌번호를 입력하세요 ");
		String b = scanner.next();
		if (findAccount(b) == null) {
			System.out.println("잘못된 계좌번호입니다.");
			return;
		}

		System.out.print("이체하실 금액을 입력하세요 ");
		int c = scanner.nextInt();
		if (findAccount(a).getBalance() - c >= 0) {
			findAccount(a).setBalance(findAccount(a).getBalance() - c);
			findAccount(b).setBalance(findAccount(b).getBalance() + c);
			System.out.println("이체가 완료되었습니다");
		} else
			System.out.println("잔액이 부족합니다");
	}

	//계좌삭제
	//삭제하고자 하는 계좌번호에 해당하는 객체를 참조하고 있는 참조변수를
	//마지막 객체를방금 삭제한 위치에 참조 시킴
	//총 객체의 갯수를 저장하는 use를 1 줄임
	private static void delete(){
		System.out.println("--------");
		System.out.println("삭제");
		System.out.println("--------");
		
		System.out.print("계좌번호입력 ");
		String a = scanner.next();
		if(findAccount(a)!=null)
			deleteAccount(a);
		else
			System.out.println("존재하지 않는 계좌번호입니다.");
	}
	
	private static void deleteAccount(String ano){
		for(int i =0; i<use; i++){
			if(accountArray[i].getAno().equals(ano))
			{
				//현재 i번째 녀석이 삭제하고자 하는 계좌번호를 갖는 객체를
				//참조하는 참조변수의 위치
				accountArray[i] = accountArray[use-1];
				use--;
				System.out.println("삭제되었습니다.");
				return;
			}
		}
	}
	
	// Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {

		for (int i = 0; i < use; i++) {
			if (ano.equals(accountArray[i].getAno())) {
				return accountArray[i];
			}
		}
		return null;
	}
}
