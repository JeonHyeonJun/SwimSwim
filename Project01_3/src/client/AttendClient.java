package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import protocol.Message;
import protocol.Subject;

public class AttendClient {
	public static void main(String[] args) {
		Socket socket = null;
		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		try {
			socket = new Socket("127.0.0.1", 5000);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			Scanner scan = new Scanner(System.in);
			boolean run = true;

			while (run) {
				System.out.println("-------------------");
				System.out.println("전자출결시스템");
				System.out.println("-------------------");
				System.out.println("1.학생 | 2.교수 | 3.종료");
				System.out.println("-------------------");
				System.out.print("선택> ");
				int select = scan.nextInt();

				if (select == 1) {
					System.out.print("id: ");
					String id = scan.next();
					System.out.print("password: ");
					String ps = scan.next();

					Message sMsg = new Message();
					sMsg.setCode(100);

					Map<String, Object> params = new HashMap<>();
					params.put("ID", id);
					params.put("PASSWORD", ps);
					sMsg.setParams(params);
					out.writeObject(sMsg);
					out.flush();
					out.reset();

					Message rMsg = (Message) in.readObject();
					if (rMsg.getCode() == 101) {
						System.out.println("로그인성공");
						List<Subject> list = (List<Subject>) rMsg.getParams().get("LIST");
						for (int i = 0; i < list.size(); i++)
							System.out.println(list.get(i));
						System.out.print("강의번호입력> ");
						String subnum = scan.next();

						sMsg = new Message();
						sMsg.setCode(110);
						params = new HashMap<>();
						params.put("SUBNUM", subnum);
						sMsg.setParams(params);
						out.writeObject(sMsg);
						out.flush();
						out.reset();

						rMsg = (Message) in.readObject();
						if (rMsg.getCode() == 111) {
							while (run) {
								System.out.print("출석번호입력> ");
								int num = scan.nextInt();

								sMsg = new Message();
								sMsg.setCode(120);
								params = new HashMap<>();
								params.put("ATT", num);
								sMsg.setParams(params);
								out.writeObject(sMsg);
								out.flush();
								out.reset();

								rMsg = (Message) in.readObject();
								if (rMsg.getCode() == 121) {
									System.out.println("출석성공");
									System.out.println(rMsg.getParams().get("SUCCESS")+"회 출석완료");
									run = false;
								} else if (rMsg.getCode() == 122) {
									System.out.println("출석실패");
								} else if (rMsg.getCode() == 123) {
									System.out.println("출석실패");
									run = false;
								}
							}
						} else if (rMsg.getCode() == 112) {
							System.out.println("올바른 강의번호를 입력해주세요");
						}
					} else if (rMsg.getCode() == 102)
						System.out.println("id 또는 password가 잘못되었습니다");
				}
				//교수
				else if (select == 2) {
					System.out.print("id: ");
					String id = scan.next();
					System.out.print("password: ");
					String ps = scan.next();

					Message sMsg = new Message();
					sMsg.setCode(200);

					Map<String, Object> params = new HashMap<>();
					params.put("ID", id);
					params.put("PASSWORD", ps);
					sMsg.setParams(params);
					out.writeObject(sMsg);
					out.flush();
					out.reset();

					Message rMsg = (Message) in.readObject();
					if (rMsg.getCode() == 201) {
						System.out.println("로그인성공");
						List<Subject> list = (List<Subject>) rMsg.getParams().get("LIST");
						for (int i = 0; i < list.size(); i++)
							System.out.println(list.get(i));
						System.out.print("강의번호입력> ");
						String subnum = scan.next();

						sMsg = new Message();
						sMsg.setCode(210);
						params = new HashMap<>();
						params.put("SUBNUM", subnum);
						sMsg.setParams(params);
						out.writeObject(sMsg);
						out.flush();
						out.reset();

						rMsg = (Message) in.readObject();
						if (rMsg.getCode() == 211) {
							System.out.println(rMsg.getParams().get("ATTNUM"));
						} else if (rMsg.getCode() == 212) {
							System.out.println("올바른 강의번호를 입력해주세요");
						}
					} else if (rMsg.getCode() == 202)
						System.out.println("id 또는 password가 잘못되었습니다");
				}

				else if (select == 3) {
					run = false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
