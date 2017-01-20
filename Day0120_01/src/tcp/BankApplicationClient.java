package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class BankApplicationClient {
	private static final String SEVER_IP = "70.12.111.105";
	private static final int SEVER_PORT = 5001;
	private static final int SEVER_PORT2 = 5002;
	private static Scanner scan = new Scanner(System.in);
	static ServerSocket server = null;
	static Socket socket = null;
	static BufferedWriter bw = null;
	static BufferedReader br = null;

	public static void main(String[] args) {
		boolean run = true;
		try {
//			server = new ServerSocket(SEVER_PORT);
//			socket = server.accept();
			socket = new Socket(SEVER_IP, SEVER_PORT);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (run) {

				System.out.println("---------------------------------------------------------");
				System.out.println("1.계좌생성 | 2.계좌리스트 | 3.예금 | 4.출금 | 5.이체 | 6.종료 | 0.삭제");
				System.out.println("---------------------------------------------------------");
				System.out.print("선택> ");

				int selectNo;
				selectNo = scan.nextInt();

				if (selectNo == 1) {
					bw.write("계좌생성\n");
					bw.flush();
					createAccount();
				} else if (selectNo == 2) {
					bw.write("계좌리스트\n");
					bw.flush();
					
					AccountList();
				} else if (selectNo == 3) {
					bw.write("예금\n");
					bw.flush();
					 deposit();
				} else if (selectNo == 4) {
					bw.write("출금\n");
					bw.flush();
					// withdraw();
				} else if (selectNo == 5) {
					bw.write("이체\n");
					bw.flush();
					// trans();
				} else if (selectNo == 6) {
					run = false;
					// save();
				} else if (selectNo == 0) {
					// delete();
				}

			} // run
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}// main

	public static void createAccount() {
		try {
//			socket = new Socket(SEVER_IP, SEVER_PORT);
			System.out.println("--------");
			System.out.println("계좌생성");
			System.out.println("--------");

			System.out.print("계좌번호: ");
			bw.write(scan.next() + "\n");
			bw.flush();

			System.out.print("계좌주: ");
			bw.write(scan.next() + "\n");
			bw.flush();

			System.out.print("초기입금액: ");
			bw.write(scan.next() + "\n");
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}// 계좌생성

	public static void AccountList() {
		try {
			server = new ServerSocket(SEVER_PORT2);
			socket = server.accept();
			// DatagramSocket socket = null;
			
			String msg = null;
			// while(!msg.equals("완료")){
			msg = br.readLine();
			System.out.println(msg);
			// }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // 계좌목록
	
	 public static void deposit() {
	 try {
	// DatagramSocket socket = null;
	 
	 System.out.println("--------");
	 System.out.println("예금");
	 System.out.println("--------");
	
	 System.out.print("계좌번호: ");
	 bw.write(scan.next() + "\n");
	 bw.flush();
	
	 System.out.print("예금액: ");
	 bw.write(scan.next() + "\n");
	 bw.flush();
	
//	 socket = new DatagramSocket(SEVER_PORT);
//	 buf = new byte[512];
//	 packet = new DatagramPacket(buf, buf.length);
//	 socket.receive(packet);
//	 String msg = new String(buf).trim();
	
//	 System.out.println("입금후금액: " +msg);
	
	 } catch (IOException e) {
	 e.printStackTrace();
	 } finally {
	
	 }
	 }
	//
	// //출금
	// public static void withdraw() {
	// try {
	// socket = new DatagramSocket();
	// System.out.println("--------");
	// System.out.println("출금");
	// System.out.println("--------");
	//
	// System.out.print("계좌번호: ");
	// byte[] buf = scan.next().getBytes();
	// DatagramPacket packet = new DatagramPacket(buf, buf.length,
	// InetAddress.getByName(SEVER_IP), SEVER_PORT);
	// socket.send(packet);
	//
	// System.out.println("출금액: ");
	// buf = scan.next().getBytes();
	// packet = new DatagramPacket(buf, buf.length,
	// InetAddress.getByName(SEVER_IP), SEVER_PORT);
	// socket.send(packet);
	//
	// socket = new DatagramSocket(SEVER_PORT);
	// buf = new byte[512];
	// packet = new DatagramPacket(buf, buf.length);
	// socket.receive(packet);
	// String msg = new String(buf).trim();
	//
	// System.out.println("출금후금액: " +msg);
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	//
	// }
	// }
	 
	 public static void receive(){
		 
	 }
}
