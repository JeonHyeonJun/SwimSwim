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

		// sub.add(new Subject(1,"ö��",0));
		// sub.add(new Subject(2,"������",0));
		// sub.add(new Subject(3,"�����",0));
		//
		// sub2.add(new Subject(3,"�����",0));

		st[0] = new Student("id1", "ps1", "����");
		st[1] = new Student("id2", "ps2", "��ҷ�");
		st[2] = new Student("id3", "ps3", "�����");
		// st[0].getSubject().set(0, "sd");

		st[0].add(1, "ö��", 0, 3);
		st[0].add(2, "������", 0, 2);
		st[1].add(3, "����", 0, 4);
		st[1].add(4, "������", 0, 4);
		st[2].add(5, "����", 0, 1);
		
//		st[0].setnum(1, 2); �⼮��ȣ����

		while (run) {
			try {
				System.out.println("-------------------");
				System.out.println("�������ý���");
				System.out.println("-------------------");
				System.out.println("1.�л� | 2.���� | 3.����");
				System.out.println("-------------------");
				System.out.print("����> ");
				int select = scan.nextInt();

				// �л��α���
				if (select == 1) {
					boolean login = false;
					boolean subselect = false;
					System.out.print("id: ");
					String b = scan.next();
					System.out.print("passward: ");
					String c = scan.next();

					// id,ps��ġ
					for (int i = 0; i < 3; i++) {
						if (b.equals(st[i].getId()) && c.equals(st[i].getPassward())) {
							System.out.println("�α��μ���");
							login = true;
							
							// ���Ǹ��+���Ǽ���
								System.out.println(st[i].getSubject());
								System.out.println("-------------------");
								System.out.print("���ǹ�ȣ�Է�> ");
								select = scan.nextInt();
							
								//�⼮��ȣ�Է�
							for (int k = 0; k < st[i].getSubject().size(); k++)
								if (select == st[i].getSubject().get(k).getSubjectcode()) {
									subselect = true;
									
									while (fail < 3 && run) {
											System.out.print("�⼮��ȣ> ");
											num = scan.nextInt();
										
											//�⼮����
										if (num !=0 && num == st[i].getSubject().get(k).getNumber()) {
											System.out.println("�⼮�� �Ϸ�Ǿ����ϴ�.");
											int tmp = st[i].getSubject().get(k).setAttendance(st[i].getSubject().get(k).getAttendance() + 1);
											System.out.println("�⼮��: " + tmp + "/" + ATTENDENCE);
											run = false;
											
											//�⼮����
										} else {
											fail++;
											System.out.println("�⼮��ȣ�� ��ġ�����ʽ��ϴ�. " +fail+"������");
										}
									} // �⼮ while
									fail = 0;	//�⼮����Ƚ�� �ʱ�ȭ
								} // ���Ǽ��ü���
							if (subselect == false) {
								System.out.println("�������� ���ǰ� �ƴմϴ�.");
							}
						}
					} // ����for

					// id,ps����ġ
					if (login == false)
						System.out.println("id �Ǵ� password�� ��ġ���� �ʽ��ϴ�.");

					// ����
				} else if (select == 2) {

					// ����
				} else if (select == 3) {
					run = false;

					// �׿ܹ�ȣ�Է�
				} else
					System.out.println("�ùٸ� ��ȣ�� �����ϼ���.");

				// �����Ҷ� ���ڿ���ó��
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է����ּ���.");
				scan.next();
			}
		} // ��üwhile
	}// main
}// AttendanceSystem
