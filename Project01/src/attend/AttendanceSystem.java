package attend;

import java.util.*;

public class AttendanceSystem {
	private static Scanner scan = new Scanner(System.in);
	static List<Student> st = new ArrayList<Student>();
	static List<Professor> prof = new ArrayList<Professor>();
	public static void main(String[] args) {
		int num = 0; // ���� �Է��� �⼮��ȣ
		int fail = 0; // �⼮��ȣ�Է� ����Ƚ��
		boolean run = true; // ���α׷�����
		final int ATTENDENCE = 15; // �� ������

		// �л� ����
		st.add(new Student("id1", "ps1", "����"));
		st.add(new Student("id2", "ps2", "��ҷ�"));
		st.add(new Student("id3", "ps3", "�����"));
		//���� ����
		prof.add(new Professor("prof01", "123", "�豳��"));
		prof.add(new Professor("prof02", "456", "�̱���"));
		prof.add(new Professor("prof03", "789", "�ڱ���"));
		// �л����� �����������
		st.get(0).add(101, "ö��", 0, 4);
		st.get(0).add(102, "������", 0, 4);
		st.get(1).add(103, "����", 0, 1);
		st.get(1).add(102, "������", 0, 0);
		st.get(2).add(104, "ö��", 0, 3);
		//�� ���� ���� ���
		prof.get(0).add(101, "ö��", 0, 4);
		prof.get(0).add(102, "������", 0, 4);
		prof.get(1).add(103, "����", 0, 1);
		prof.get(1).add(102, "������", 0, 0);
		prof.get(2).add(102, "������", 0, 4);
		prof.get(2).add(103, "����", 0, 1);
		// ���α׷�����
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
					System.out.print("password: ");
					String c = scan.next();

					// id,ps��ġ
					for (int i = 0; i < st.size(); i++) {
						if (b.equals(st.get(i).getId()) && c.equals(st.get(i).getPassword())) {
							System.out.println("�α��μ���");
							login = true;

							// ���Ǹ��+���Ǽ���
							System.out.println(st.get(i).getSubject());
							System.out.println("-------------------");
							System.out.print("���ǹ�ȣ�Է�> ");
							select = scan.nextInt();

							// �⼮üũ
							for (int k = 0; k < st.get(i).getSubject().size(); k++)
								if (select == st.get(i).getSubject().get(k).getSubjectcode()) {
									subselect = true;

									while (fail < 3 && run) {


										// �⼮��ȣ�Է�
										System.out.print("�⼮��ȣ> ");
										num = scan.nextInt();

										// �⼮����
										if (num != 0 && num == st.get(i).getSubject().get(k).getNumber()) {
											System.out.println("�⼮�� �Ϸ�Ǿ����ϴ�.");
											int tmp = st.get(i).getSubject().get(k)
													.setAttendance(st.get(i).getSubject().get(k).getAttendance() + 1);
											System.out.println("�⼮��: " + tmp + "/" + ATTENDENCE);
											run = false;

										// �⼮����
										} else {
											fail++;
											System.out.println("�⼮��ȣ�� ��ġ�����ʽ��ϴ�. " + fail + "������");
										}
									} // �⼮ while ��
									
									fail = 0; // �⼮����Ƚ�� �ʱ�ȭ
									
								} // ���Ǽ��ü�����
							
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
					boolean login = false;
					boolean subselect = false;
					System.out.print("id: ");
					String b = scan.next();
					System.out.print("password: ");
					String c = scan.next();

					// id,ps��ġ
					for (int i = 0; i < prof.size(); i++) {
						if (b.equals(prof.get(i).getId()) && c.equals(prof.get(i).getPassword())) {
							System.out.println("�α��μ���");
							login = true;

							// ���Ǹ��+���Ǽ���
							System.out.println(prof.get(i).getSubject());
							System.out.println("-------------------");
							System.out.print("���ǹ�ȣ�Է�> ");
							select = scan.nextInt();

							// �⼮üũ
							for (int k = 0; k <prof.get(i).getSubject().size(); k++)
								if (select == prof.get(i).getSubject().get(k).getSubjectcode()) {
									subselect = true;
									
									// �⼮��ȣ���
									int answer = (int) (Math.random() * 100) + 1;
									System.out.println(answer);
									for(int j=0; j<st.size(); j++){
										for(int q=0; q<st.get(j).getSubject().size(); q++){
											if(st.get(j).getSubject().get(q).getSubjectcode() == prof.get(i).getSubject().get(k).getSubjectcode())
												st.get(j).getSubject().get(q).setNumber(answer);
										}
									}
										
//										answer = st.get(i).getSubject().get(k).setNumber((int) (Math.random() * 100) + 1);
									
								} // ���Ǽ��ü�����
							
							if (subselect == false) {
								System.out.println("�������� ���ǰ� �ƴմϴ�.");
							}
						}
					} // ����for

					// id,ps����ġ
					if (login == false)
						System.out.println("id �Ǵ� password�� ��ġ���� �ʽ��ϴ�.");

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