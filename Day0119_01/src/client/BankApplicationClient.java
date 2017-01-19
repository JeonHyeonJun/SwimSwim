package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class BankApplicationClient {
	private static final String SEVER_IP = "70.12.111.99";
	private static final int SEVER_PORT = 4003;
	private static Scanner scan = new Scanner(System.in);
	static DatagramSocket socket = null;

	public static void main(String[] args) {
		boolean run = true;
		try {
			socket = new DatagramSocket();
			while (run) {

				System.out.println("---------------------------------------------------------");
				System.out.println("1.계좌생성 | 2.계좌리스트 | 3.예금 | 4.출금 | 5.이체 | 6.종료 | 0.삭제");
				System.out.println("---------------------------------------------------------");
				System.out.print("선택> ");

				int selectNo;
				selectNo = scan.nextInt();

				if (selectNo == 1) {

					byte[] buf = "계좌생성".getBytes();
					DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP),
							SEVER_PORT);
					socket.send(packet);
					createAccount();
				} else if (selectNo == 2) {
					byte[] buf = "계좌리스트".getBytes();
					DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP),
							SEVER_PORT);
					socket.send(packet);
					AccountList();
				} else if (selectNo == 3) {
					byte[] buf = "입금".getBytes();
					DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP),
							SEVER_PORT);
					socket.send(packet);
					deposit();
				} else if (selectNo == 4) {
					byte[] buf = "출금".getBytes();
					DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP),
							SEVER_PORT);
					socket.send(packet);
					withdraw();
				} else if (selectNo == 5) {
					byte[] buf = "이체".getBytes();
					DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP),
							SEVER_PORT);
					socket.send(packet);
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
			socket = new DatagramSocket();
			System.out.println("--------");
			System.out.println("계좌생성");
			System.out.println("--------");

			System.out.print("계좌번호: ");
			byte[] buf = scan.next().getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
			socket.send(packet);

			System.out.print("계좌주: ");
			buf = scan.next().getBytes();
			packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
			socket.send(packet);

			System.out.print("초기입금액: ");
			buf = scan.next().getBytes();
			packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}// 계좌생성

	public static void AccountList() {
		try {
//			DatagramSocket socket = null;
			socket = new DatagramSocket(SEVER_PORT);
			String msg = "";
			// while(!msg.equals("완료")){
			byte[] buf = new byte[512];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			msg = new String(buf).trim();
			System.out.println(msg);
			// }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	} // 계좌목록

	public static void deposit() {
		try {
//			DatagramSocket socket = null;
			socket = new DatagramSocket();
			System.out.println("--------");
			System.out.println("예금");
			System.out.println("--------");

			System.out.print("계좌번호: ");
			byte[] buf = scan.next().getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
			socket.send(packet);
			
			System.out.print("예금액: ");
			buf = scan.next().getBytes();
			packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
			socket.send(packet);
			
			socket = new DatagramSocket(SEVER_PORT);
			buf = new byte[512];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String msg = new String(buf).trim();
			
			System.out.println("입금후금액: " +msg);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
	
	//출금
	public static void withdraw() {
		try {
			socket = new DatagramSocket();
			System.out.println("--------");
			System.out.println("출금");
			System.out.println("--------");

			System.out.print("계좌번호: ");
			byte[] buf = scan.next().getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
			socket.send(packet);

			System.out.println("출금액: ");
			buf = scan.next().getBytes();
			packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
			socket.send(packet);
			
			socket = new DatagramSocket(SEVER_PORT);
			buf = new byte[512];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String msg = new String(buf).trim();
			
			System.out.println("출금후금액: " +msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
