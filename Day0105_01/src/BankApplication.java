import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	private static int use = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.��ü | 6.���� | 0.����");
			System.out.println("---------------------------------------------------------");
			System.out.print("����> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				if (use < accountArray.length)
					createAccount();
				else
					System.out.println("���¸� ���̻� ����� �����ϴ�.");
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
		System.out.println("���α׷� ����");
	}

	// ���»���
	private static void createAccount() {
		System.out.println("--------");
		System.out.println("���»���");
		System.out.println("--------");

		System.out.print("���¹�ȣ: ");
		String a = scanner.next();

		if (findAccount(a) != null) {
			System.out.println("�̹� �����ϴ� ���¹�ȣ�Դϴ�.");
			return;
		}

		System.out.print("������: ");
		String b = scanner.next();
		System.out.print("�ʱ��Աݾ�: ");
		int c = scanner.nextInt();
		if(c<Account.getMIN_BALANCE() || c>Account.getMAX_BALANCE()){
			System.out.println("�ùٸ� �ݾ��� �ƴմϴ�.(0~1000000)");
			return;
		}
		accountArray[use] = new Account(a, b, c);
		System.out.println("���: ���°� �����Ǿ����ϴ�.");
		use++;
	}

	// ���¸��
	private static void accountList() {
		System.out.println("--------");
		System.out.println("���¸��");
		System.out.println("--------");

		for (int i = 0; i < use; i++)
			System.out.println(accountArray[i]);
	}

	// ����
	private static void deposit() {
		System.out.println("--------");
		System.out.println("����");
		System.out.println("--------");

		System.out.print("���¹�ȣ: ");
		String a = scanner.next();
		if (findAccount(a) != null) {
			System.out.print("���ݾ�: ");
			int b = scanner.nextInt();
			findAccount(a).setBalance(findAccount(a).getBalance() + b);
			System.out.println("���: ������ �����Ǿ����ϴ�.");
		} else
			System.out.println("���°� �������� �ʽ��ϴ�.");
	}

	// ���
	private static void withdraw() {
		System.out.println("--------");
		System.out.println("���");
		System.out.println("--------");

		System.out.print("���¹�ȣ: ");
		String a = scanner.next();
		if (findAccount(a) != null) {
			System.out.print("��ݾ�: ");
			int b = scanner.nextInt();

			if (findAccount(a).getBalance() - b >= 0) {
				findAccount(a).setBalance(findAccount(a).getBalance() - b);
				System.out.println("���: ����� �����Ǿ����ϴ�.");
			} else
				System.out.println("�ܾ��� �����մϴ�.");
		} else
			System.out.println("���°� �������� �ʽ��ϴ�.");
	}

	// ��ü
	private static void trans() {
		System.out.println("--------");
		System.out.println("��ü");
		System.out.println("--------");

		System.out.print("����Ͻ� ������ ���¹�ȣ�� �Է��ϼ��� ");
		String a = scanner.next();
		if (findAccount(a) == null) {
			System.out.println("�߸��� ���¹�ȣ�Դϴ�.");
			return;
		}

		System.out.print("�޴� ������ ���¹�ȣ�� �Է��ϼ��� ");
		String b = scanner.next();
		if (findAccount(b) == null) {
			System.out.println("�߸��� ���¹�ȣ�Դϴ�.");
			return;
		}

		System.out.print("��ü�Ͻ� �ݾ��� �Է��ϼ��� ");
		int c = scanner.nextInt();
		if (findAccount(a).getBalance() - c >= 0) {
			findAccount(a).setBalance(findAccount(a).getBalance() - c);
			findAccount(b).setBalance(findAccount(b).getBalance() + c);
			System.out.println("��ü�� �Ϸ�Ǿ����ϴ�");
		} else
			System.out.println("�ܾ��� �����մϴ�");
	}

	//���»���
	//�����ϰ��� �ϴ� ���¹�ȣ�� �ش��ϴ� ��ü�� �����ϰ� �ִ� ����������
	//������ ��ü����� ������ ��ġ�� ���� ��Ŵ
	//�� ��ü�� ������ �����ϴ� use�� 1 ����
	private static void delete(){
		System.out.println("--------");
		System.out.println("����");
		System.out.println("--------");
		
		System.out.print("���¹�ȣ�Է� ");
		String a = scanner.next();
		if(findAccount(a)!=null)
			deleteAccount(a);
		else
			System.out.println("�������� �ʴ� ���¹�ȣ�Դϴ�.");
	}
	
	private static void deleteAccount(String ano){
		for(int i =0; i<use; i++){
			if(accountArray[i].getAno().equals(ano))
			{
				//���� i��° �༮�� �����ϰ��� �ϴ� ���¹�ȣ�� ���� ��ü��
				//�����ϴ� ���������� ��ġ
				accountArray[i] = accountArray[use-1];
				use--;
				System.out.println("�����Ǿ����ϴ�.");
				return;
			}
		}
	}
	
	// Account �迭���� ano�� ������ Account ��ü ã��
	private static Account findAccount(String ano) {

		for (int i = 0; i < use; i++) {
			if (ano.equals(accountArray[i].getAno())) {
				return accountArray[i];
			}
		}
		return null;
	}
}
