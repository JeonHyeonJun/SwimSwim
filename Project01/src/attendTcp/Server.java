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

			// 프로그램시작
			while (run) {

				send(0, null);

				rMsg = (Message) in.readObject();
				int code = rMsg.getCode();

				// 학생로그인
				if (code == 100) {
					student();
					// 교수로그인
				} else if (code == 200) {
					professor();
					// 프로그램종료
				} else if (code == 300) {
					run = false;
					System.out.println("종료");
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

	// 학생
	public static void student() {
		try {
			boolean login = false;
			boolean subselect = false;
			rMsg = (Message) in.readObject();
			rMsg2 = (Message) in.readObject();

			for (int i = 0; i < st.size(); i++) {

				// 로그인성공
				if (rMsg.getObj().equals(st.get(i).getId()) && rMsg2.getObj().equals(st.get(i).getPassword())) {
					login = true;
					send(101, st.get(i).getSubject());
					rMsg = (Message) in.readObject();

					// 강의선택
					if (rMsg.getCode() == 110) {
						for (int j = 0; j < st.get(i).getSubject().size(); j++) {

							// 강의선택성공
							if ((int) rMsg.getObj() == st.get(i).getSubject().get(j).getSubjectcode()) {
								subselect = true;
								send(111, null);
								while (fail < 3 && run) {
									rMsg = (Message) in.readObject();

									// 출석
									if (rMsg.getCode() == 120) {

										// 출석성공
										if ((int) rMsg.getObj() == st.get(i).getSubject().get(j).getNumber() && (int) rMsg.getObj() != 0) {
											int att = st.get(i).getSubject().get(j)
													.setAttendance(st.get(i).getSubject().get(j).getAttendance() + 1);	//출석횟수증가
											
											st.get(i).getSubject().get(j).setNumber(0);	//출석번호초기화
											send(121, att);
											run = false;
											save();
											// 출석실패
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
						// 강의선택실패
						if (subselect == false)
							send(112, null);
					}
				}
			}
			// 로그인실패
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
				// 로그인성공
				if (rMsg.getObj().equals(prof.get(i).getId()) && rMsg2.getObj().equals(prof.get(i).getPassword())) {
					login = true;
					send(201, prof.get(i).getSubject());
					rMsg = (Message) in.readObject();

					// 강의선택
					if (rMsg.getCode() == 210) {
						for (int j = 0; j < prof.get(i).getSubject().size(); j++) {

							// 강의선택성공
							if ((int) rMsg.getObj() == prof.get(i).getSubject().get(j).getSubjectcode()) {
								subselect = true;
								int answer = (int) (Math.random() * 100) + 1;
								for (int k = 0; k < st.size(); k++) {
									for (int q = 0; q < st.get(k).getSubject().size(); q++) {
										if (st.get(k).getSubject().get(q).getSubjectcode() == prof.get(i).getSubject()
												.get(j).getSubjectcode())

											st.get(k).getSubject().get(q).setNumber(answer);	//출석번호생성	
									}
								}
								send(211, answer);
							}
						}
						// 강의선택실패
						if (subselect == false)
							send(212, null);
					}
				}
			}
			// 로그인실패
			if (login == false)
				send(202, null);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 보내기
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

	// 불러오기
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

			// 학생 생성
			st.add(new Student("id1", "ps1", "김모범"));
			st.add(new Student("id2", "ps2", "김불량"));
			st.add(new Student("id3", "ps3", "김평범"));
			// 교수 생성
			prof.add(new Professor("prof01", "123", "김교수"));
			prof.add(new Professor("prof02", "456", "이교수"));
			prof.add(new Professor("prof03", "789", "박교수"));
			// 학생마다 수강과목생성
			st.get(0).add(101, "철학", 0, 0);
			st.get(0).add(102, "물리학", 0, 0);
			st.get(1).add(103, "과학", 0, 0);
			st.get(1).add(102, "물리학", 0, 0);
			st.get(2).add(104, "철학", 0, 0);
			// 각 교수 강의 목록
			prof.get(0).add(101, "철학", 0, 4);
			prof.get(0).add(102, "물리학", 0, 4);
			prof.get(1).add(103, "과학", 0, 1);
			prof.get(1).add(102, "물리학", 0, 0);
			prof.get(2).add(102, "물리학", 0, 4);
			prof.get(2).add(103, "과학", 0, 1);

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

	// 저장하기
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
