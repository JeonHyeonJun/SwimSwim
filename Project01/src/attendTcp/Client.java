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
						System.out.println("�������ý���");
						System.out.println("-------------------");
						System.out.println("1.�л� | 2.���� | 3.����");
						System.out.println("-------------------");
						System.out.print("����> ");
						select = scan.nextInt();

						if (select == 1) {
							student();
						} else if (select == 2) {
							professor();
						} else if (select == 3) {
							send(300,null);
							System.out.println("�����մϴ�");
							run = false;
						}
					}
				//���ڿ���ó��
				} catch (InputMismatchException e) {
					System.out.println("���ڸ� �Է����ּ���");
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

	
	
	// �л�
	public static void student() {
		try {
			send(100, null);
			System.out.print("id: ");
			send(100, scan.next());
			System.out.print("password: ");
			send(100, scan.next());
			rMsg = (Message) in.readObject();
			
			//�α��μ���
			if (rMsg.getCode() == 101) {
				System.out.println("�α��μ���");
				System.out.println(rMsg.getObj());
				System.out.print("���ǹ�ȣ�Է�> ");
				subjectNum = scan.nextInt();
				send(110, subjectNum);
				rMsg = (Message) in.readObject();
				
				//���Ǽ��ü���
				if (rMsg.getCode() == 111) {
					while (rMsg.getCode() != 123 && rMsg.getCode() != 121) {
						System.out.print("�⼮��ȣ> ");
						AttendNum = scan.nextInt();
						send(120, AttendNum);
						rMsg = (Message) in.readObject();
						
						//�⼮����
						if (rMsg.getCode() == 121) {
							System.out.println("�⼮�Ϸ�");
							System.out.println("�⼮Ƚ��: " + rMsg.getObj());
							run = false;
						//�⼮����
						} else if (rMsg.getCode() == 122) {
							System.out.println("�⼮��ȣ�� ��ġ���� �ʽ��ϴ� " + rMsg.getObj() + "�� ����");
						//�⼮3������
						} else if (rMsg.getCode() == 123) {
							System.out.println("�⼮����");
							run = false;
						}
					}
				//���Ǽ��ý���
				} else if (rMsg.getCode() == 112) {
					System.out.println("���ǹ�ȣ�� ��ġ�����ʽ��ϴ�.");
				}
			//�α��ν���
			} else if (rMsg.getCode() == 102) {
				System.out.println("�α��ν���");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//����
	public static void professor(){
		try{
			send(200,null);
			System.out.print("id: ");
			send(200, scan.next());
			System.out.print("password: ");
			send(200, scan.next());
			rMsg = (Message) in.readObject();
			
			//�α��μ���
			if (rMsg.getCode() == 201) {
				System.out.println("�α��μ���");
				System.out.println(rMsg.getObj());
				System.out.print("���ǹ�ȣ�Է�> ");
				subjectNum = scan.nextInt();
				send(210, subjectNum);
				rMsg = (Message) in.readObject();
				
				//���Ǽ��ü���
				if (rMsg.getCode() == 211) {
					System.out.println(rMsg.getObj());
				//���Ǽ��ý���
				} else if (rMsg.getCode() == 212){
					System.out.println("���ǹ�ȣ�� ��ġ���� �ʽ��ϴ�");
				}
			//�α��ν���
			} else if (rMsg.getCode() == 202) {
				System.out.println("�α��ν���");
			}
			
		} catch(IOException | ClassNotFoundException e){
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
}// class
