package attendTcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Server {
	static final int PORT = 5000;
	static ServerSocket server = null;
	static Socket socket = null;
	static ObjectOutputStream out = null;
	static ObjectInputStream in = null;
	static List<Student> st = new ArrayList<Student>();
	static List<Professor> prof = new ArrayList<Professor>();
	static Message msg = new Message();
	static Message rMsg, rMsg2 = null;
	static int fail = 0;
	static boolean run = true;

	public static void main(String[] args) {
		try {
			server = new ServerSocket(PORT);
			socket = server.accept();
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

			load();

			// ���α׷�����
			while (run) {

				send(0, null);

				rMsg = (Message) in.readObject();
				int code = rMsg.getCode();

				// �л��α���
				if (code == 100) {
					student();
					// �����α���
				} else if (code == 200) {
					professor();
					// ���α׷�����
				} else if (code == 300) {
					run = false;
					System.out.println("����");
					save();
				}

			} // while

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
				if (server != null)
					server.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}// main

	// �л�
	public static void student() {
		try {
			boolean login = false;
			boolean subselect = false;
			rMsg = (Message) in.readObject();
			rMsg2 = (Message) in.readObject();

			for (int i = 0; i < st.size(); i++) {

				// �α��μ���
				if (rMsg.getObj().equals(st.get(i).getId()) && rMsg2.getObj().equals(st.get(i).getPassword())) {
					login = true;
					send(101, st.get(i).getSubject());
					rMsg = (Message) in.readObject();

					// ���Ǽ���
					if (rMsg.getCode() == 110) {
						for (int j = 0; j < st.get(i).getSubject().size(); j++) {

							// ���Ǽ��ü���
							if ((int) rMsg.getObj() == st.get(i).getSubject().get(j).getSubjectcode()) {
								subselect = true;
								send(111, null);
								while (fail < 3 && run) {
									rMsg = (Message) in.readObject();

									// �⼮
									if (rMsg.getCode() == 120) {

										// �⼮����
										if ((int) rMsg.getObj() == st.get(i).getSubject().get(j).getNumber() && (int) rMsg.getObj() != 0) {
											int att = st.get(i).getSubject().get(j)
													.setAttendance(st.get(i).getSubject().get(j).getAttendance() + 1);	//�⼮Ƚ������
											
											st.get(i).getSubject().get(j).setNumber(0);	//�⼮��ȣ�ʱ�ȭ
											send(121, att);
											run = false;
											save();
											// �⼮����
										} else {
											fail++;
											if (fail != 3)
												send(122, fail);
										}
									}
								}
								if (fail == 3) {
									send(123, null);
									fail = 0;
									run = false;
									save();
								}
							}

						}
						// ���Ǽ��ý���
						if (subselect == false)
							send(112, null);
					}
				}
			}
			// �α��ν���
			if (login == false)
				send(102, null);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void professor() {
		try {
			boolean login = false;
			boolean subselect = false;
			rMsg = (Message) in.readObject();
			rMsg2 = (Message) in.readObject();

			for (int i = 0; i < prof.size(); i++) {
				// �α��μ���
				if (rMsg.getObj().equals(prof.get(i).getId()) && rMsg2.getObj().equals(prof.get(i).getPassword())) {
					login = true;
					send(201, prof.get(i).getSubject());
					rMsg = (Message) in.readObject();

					// ���Ǽ���
					if (rMsg.getCode() == 210) {
						for (int j = 0; j < prof.get(i).getSubject().size(); j++) {

							// ���Ǽ��ü���
							if ((int) rMsg.getObj() == prof.get(i).getSubject().get(j).getSubjectcode()) {
								subselect = true;
								int answer = (int) (Math.random() * 100) + 1;
								for (int k = 0; k < st.size(); k++) {
									for (int q = 0; q < st.get(k).getSubject().size(); q++) {
										if (st.get(k).getSubject().get(q).getSubjectcode() == prof.get(i).getSubject()
												.get(j).getSubjectcode())

											st.get(k).getSubject().get(q).setNumber(answer);	//�⼮��ȣ����	
									}
								}
								send(211, answer);
							}
						}
						// ���Ǽ��ý���
						if (subselect == false)
							send(212, null);
					}
				}
			}
			// �α��ν���
			if (login == false)
				send(202, null);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ������
	public static void send(int code, Object obj) {
		try {
			msg.setCode(code);
			msg.setObj(obj);
			out.writeObject(msg);
			out.flush();
			out.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// �ҷ�����
	public static void load() {
		ObjectInputStream stin = null;
		ObjectInputStream prin = null;

		try {
			stin = new ObjectInputStream(new FileInputStream("st.dat"));
			prin = new ObjectInputStream(new FileInputStream("pr.dat"));

			st = (List<Student>) stin.readObject();
			prof = (List<Professor>) prin.readObject();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			st = new ArrayList<Student>();
			prof = new ArrayList<Professor>();

			// �л� ����
			st.add(new Student("id1", "ps1", "����"));
			st.add(new Student("id2", "ps2", "��ҷ�"));
			st.add(new Student("id3", "ps3", "�����"));
			// ���� ����
			prof.add(new Professor("prof01", "123", "�豳��"));
			prof.add(new Professor("prof02", "456", "�̱���"));
			prof.add(new Professor("prof03", "789", "�ڱ���"));
			// �л����� �����������
			st.get(0).add(101, "ö��", 0, 0);
			st.get(0).add(102, "������", 0, 0);
			st.get(1).add(103, "����", 0, 0);
			st.get(1).add(102, "������", 0, 0);
			st.get(2).add(104, "ö��", 0, 0);
			// �� ���� ���� ���
			prof.get(0).add(101, "ö��", 0, 4);
			prof.get(0).add(102, "������", 0, 4);
			prof.get(1).add(103, "����", 0, 1);
			prof.get(1).add(102, "������", 0, 0);
			prof.get(2).add(102, "������", 0, 4);
			prof.get(2).add(103, "����", 0, 1);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stin != null)
					stin.close();
				if (stin != null)
					prin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// �����ϱ�
	public static void save() {
		ObjectOutputStream stout = null;
		ObjectOutputStream prout = null;

		try {
			stout = new ObjectOutputStream(new FileOutputStream("st.dat"));
			prout = new ObjectOutputStream(new FileOutputStream("pr.dat"));
			stout.writeObject(st);
			prout.writeObject(prof);
			stout.flush();
			prout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stout != null)
					stout.close();
				if (prout != null)
					prout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}// class
