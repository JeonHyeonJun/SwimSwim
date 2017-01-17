import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
	private static List<Account2> Account2Array = new ArrayList<Account2>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		load();
		
		while (run) {
			
			System.out.println("---------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.이체 | 6.종료 | 0.삭제");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo;
			try {
				selectNo = scanner.nextInt();
				if (selectNo == 1) {
					createAccount2();
				} else if (selectNo == 2) {
					Account2List();
				} else if (selectNo == 3) {
					deposit();
				} else if (selectNo == 4) {
					withdraw();
				} else if (selectNo == 5) {
					trans();
				} else if (selectNo == 6) {
					run = false;
					save();
				} else if (selectNo == 0) {
					delete();
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자입력하세요");
				scanner.next();
			} 
		}
		System.out.println("프로그램 종료");
	}

	private static char[] writeObject(List<Account2> account2Array2) {
		// TODO Auto-generated method stub
		return null;
	}

	// 계좌생성
	private static void createAccount2() {
		System.out.println(Account2Array.size());
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");

		System.out.print("계좌번호: ");
		try {
			String a = scanner.next();
			numberlength(a);
			if (findAccount2(a) != null) {
				System.out.println("이미 존재하는 계좌번호임다");
				return;
			}
			System.out.print("계좌주: ");
			String b = scanner.next();
			System.out.print("초기입금액: ");
			int c = scanner.nextInt();
			if (c < Account2.getMIN_BALANCE() || c > Account2.getMAX_BALANCE()) {
				System.out.println("1회 입금한도초과 (0~1000000)");
				return;
			}
			Account2Array.add(new Account2(a, b, c));
			System.out.println("결과: 계좌가 생성되었습니다.");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 계좌목록
	private static void Account2List() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");

		for (int i = 0; i < Account2Array.size(); i++)
			System.out.println(Account2Array.get(i));
	}

	// 예금
	private static void deposit() {
		System.out.println("--------");
		System.out.println("예금");
		System.out.println("--------");

		System.out.print("계좌번호: ");
		String a = scanner.next();
		if (findAccount2(a) != null) {
			System.out.print("예금액: ");
			int b = scanner.nextInt();
			findAccount2(a).setBalance(findAccount2(a).getBalance() + b);
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
		if (findAccount2(a) != null) {
			System.out.print("출금액: ");
			int b = scanner.nextInt();
			try {
				nomoney(a, b);
				findAccount2(a).setBalance(findAccount2(a).getBalance() - b);
				System.out.println("결과: 출금이 성공되었습니다.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

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
		if (findAccount2(a) == null) {
			System.out.println("존재안함");
			return;
		}

		System.out.print("입금계좌입력 ");
		String b = scanner.next();
		if (findAccount2(b) == null) {
			System.out.println("존재안함");
			return;
		}

		System.out.print("금액 ");
		int c = scanner.nextInt();
		try {
			nomoney(a, c);
			findAccount2(a).setBalance(findAccount2(a).getBalance() - c);
			findAccount2(b).setBalance(findAccount2(b).getBalance() + c);
			System.out.println("완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// 삭제
	private static void delete() {
		System.out.println("--------");
		System.out.println("삭제");
		System.out.println("--------");

		System.out.print("계좌번호입력 ");
		String a = scanner.next();
		if (findAccount2(a) != null)
			deleteAccount2(a);
		else
			System.out.println("존재안함");
	}

	private static void deleteAccount2(String ano) {
		for (int i = 0; i < Account2Array.size(); i++) {
			if (Account2Array.get(i).getAno().equals(ano)) {
				Account2Array.remove(i);
				System.out.println("삭제완료");
				return;
			}
		}
	}

	// 중복확인
	private static Account2 findAccount2(String ano) {

		for (int i = 0; i < Account2Array.size(); i++) {
			if (Account2Array.get(i).getAno().equals(ano)) {
				return Account2Array.get(i);
			}
		}
		return null;
	}

	// 돈없을때
	public static void nomoney(String money, int b) throws NomoneyException {
		if (findAccount2(money).getBalance() - b < 0) {
			throw new NomoneyException("니돈없다");
		}
	}

	// 계좌번호 8자리미만으로
	public static void numberlength(String a) throws NumlengthException {
		if (a.length() >= 8) {
			throw new NumlengthException("계좌번호는 -포함 8자리미만입니다 ");
		}
	}
	
	public static void load(){
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("data.dat"));
			try {
				Account2Array = (List<Account2>) in.readObject();	//Account2Array에 data.dat에 있던 정보를 읽어서 대입한다.
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//파일없을때
		} catch (FileNotFoundException e){
			Account2Array = new ArrayList<Account2>();
		}
		catch (IOException e){
			e.printStackTrace();
		} 
		finally{
			try{
			if(in !=null)
				in.close();
			} catch (IOException e){
				
			}
		}
	}
	public static void save(){
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("data.dat"));
			out.writeObject(Account2Array);
			out.flush();
		} catch (IOException e){
			
		}finally{
			try{
			if(out !=null)
				out.close();
			} catch (IOException e){
				
			}
		}
	}
}
