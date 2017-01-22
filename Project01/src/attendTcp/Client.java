package attendTcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
	static Scanner scan = new Scanner(System.in);
	static final String IP = "192.168.0.6";
	static final int PORT = 5000;
	static Socket socket = null;
	static ObjectOutputStream out = null;
	static ObjectInputStream in = null;
	static Message msg = new Message();
	static Message rMsg = null;
	static int AttendNum, subjectNum;
	static boolean run = true;

	public static void main(String[] args) {
		try {
			socket = new Socket(IP, PORT);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

			int select;

			while (run) {
				try {
					rMsg = (Message) in.readObject();
					int code = rMsg.getCode();
					if (code == 0) {
						System.out.println("-------------------");
						System.out.println("전자출결시스템");
						System.out.println("-------------------");
						System.out.println("1.학생 | 2.교수 | 3.종료");
						System.out.println("-------------------");
						System.out.print("선택> ");
						select = scan.nextInt();

						if (select == 1) {
							student();
						} else if (select == 2) {
							professor();
						} else if (select == 3) {
							send(300,null);
							System.out.println("종료합니다");
							run = false;
						}
					}
				//숫자예외처리
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력해주세요");
					scan.next();
					send(0,null);
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
			send(100, null);
			System.out.print("id: ");
			send(100, scan.next());
			System.out.print("password: ");
			send(100, scan.next());
			rMsg = (Message) in.readObject();
			
			//로그인성공
			if (rMsg.getCode() == 101) {
				System.out.println("로그인성공");
				System.out.println(rMsg.getObj());
				System.out.print("강의번호입력> ");
				subjectNum = scan.nextInt();
				send(110, subjectNum);
				rMsg = (Message) in.readObject();
				
				//강의선택성공
				if (rMsg.getCode() == 111) {
					while (rMsg.getCode() != 123 && rMsg.getCode() != 121) {
						System.out.print("출석번호> ");
						AttendNum = scan.nextInt();
						send(120, AttendNum);
						rMsg = (Message) in.readObject();
						
						//출석성공
						if (rMsg.getCode() == 121) {
							System.out.println("출석완료");
							System.out.println("출석횟수: " + rMsg.getObj());
							run = false;
						//출석실패
						} else if (rMsg.getCode() == 122) {
							System.out.println("출석번호가 일치하지 않습니다 " + rMsg.getObj() + "번 실패");
						//출석3번실패
						} else if (rMsg.getCode() == 123) {
							System.out.println("출석실패");
							run = false;
						}
					}
				//강의선택실패
				} else if (rMsg.getCode() == 112) {
					System.out.println("강의번호가 일치하지않습니다.");
				}
			//로그인실패
			} else if (rMsg.getCode() == 102) {
				System.out.println("로그인실패");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//교수
	public static void professor(){
		try{
			send(200,null);
			System.out.print("id: ");
			send(200, scan.next());
			System.out.print("password: ");
			send(200, scan.next());
			rMsg = (Message) in.readObject();
			
			//로그인성공
			if (rMsg.getCode() == 201) {
				System.out.println("로그인성공");
				System.out.println(rMsg.getObj());
				System.out.print("강의번호입력> ");
				subjectNum = scan.nextInt();
				send(210, subjectNum);
				rMsg = (Message) in.readObject();
				
				//강의선택성공
				if (rMsg.getCode() == 211) {
					System.out.println(rMsg.getObj());
				//강의선택실패
				} else if (rMsg.getCode() == 212){
					System.out.println("강의번호가 일치하지 않습니다");
				}
			//로그인실패
			} else if (rMsg.getCode() == 202) {
				System.out.println("로그인실패");
			}
			
		} catch(IOException | ClassNotFoundException e){
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
}// class
