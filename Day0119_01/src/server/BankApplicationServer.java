package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class BankApplicationServer {
	private static final String SEVER_IP = "70.12.111.100";
	private static final int SEVER_PORT = 4003;
	static List<Account> account = new ArrayList<Account>();

	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			socket = new DatagramSocket(SEVER_PORT);
			while (true) {
				byte[] buf = new byte[512];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String msg = new String(buf).trim();

				if (msg.equals("계좌생성")) {
					System.out.println("계좌를생성합니다.");

					String[] money = new String[3];
					for (int i = 0; i < money.length; i++) {
						buf = new byte[512];
						packet = new DatagramPacket(buf, buf.length);
						socket.receive(packet);
						money[i] = new String(buf).trim();
					}
					account.add(new Account(money[0], money[1], Integer.parseInt(money[2])));
					System.out.println(account);

					buf = "생성이 완료되었습니다.".getBytes();
					packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
					socket.send(packet);

				} else if (msg.equals("계좌리스트")) {
					System.out.println("계좌목록을 보여줍니다");
					// buf = account.toString().getBytes();
					// for(int i=0; i<account.size(); i++){
					// buf = account.get(i).toString().getBytes();
					buf = account.toString().getBytes();
					packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
					socket.send(packet);
					// }
					// buf = "완료".getBytes();
					// packet = new DatagramPacket(buf, buf.length,
					// InetAddress.getByName(SEVER_IP),SEVER_PORT);
					// socket.send(packet);

				} else if (msg.equals("예금")) {
					System.out.println("예금을 시작합니다.");

					String[] tmp = new String[2];
					for (int i = 0; i < 2; i++) {
						// if (account.get(i).getAno().equals(tmp)) {
						buf = new byte[512];
						packet = new DatagramPacket(buf, buf.length);
						socket.receive(packet);
						tmp[i] = new String(buf).trim();
					}
						if (findAccount(tmp[0]) != null) {
							int money = Integer.parseInt(tmp[1]);
							findAccount(tmp[0]).setBalance(findAccount(tmp[0]).getBalance() + money);

							String m = String.valueOf(findAccount(tmp[0]).getBalance());
							buf = m.getBytes();
							packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
							socket.send(packet);
							System.out.println("전송완료");
						} else {
							buf = "계좌가 올바르지않습니다".getBytes();
							packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP), SEVER_PORT);
							socket.send(packet);
							System.out.println("ㄴ계좌");
						}

						// } else {
						// buf = "ㅈ못된 계좌입니다".getBytes();
						// packet = new DatagramPacket(buf, buf.length,
						// InetAddress.getByName(SEVER_IP),SEVER_PORT);
						// socket.send(packet);
						// System.out.println("ㅈ못");
						// }
					

				} else if (msg.equals("출금")) {
					System.out.println("출금을 시작합니다.");

					String[] tmp = new String[2];
					for (int i = 0; i < 2; i++) {
						// if (account.get(i).getAno().equals(tmp)) {
						buf = new byte[512];
						packet = new DatagramPacket(buf, buf.length);
						socket.receive(packet);
						tmp[i] = new String(buf).trim();
					}
						if (findAccount(tmp[0]) != null) {
							int money = Integer.parseInt(tmp[1]);
							if (findAccount(tmp[0]).getBalance() - money >= 0) {
								findAccount(tmp[0]).setBalance(findAccount(tmp[0]).getBalance() - money);

								String m = String.valueOf(findAccount(tmp[0]).getBalance());
								buf = m.getBytes();
								packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SEVER_IP),
										SEVER_PORT);
								socket.send(packet);

								buf = "출금완료".getBytes();
								packet = new DatagramPacket(buf, buf.length);
								socket.receive(packet);
							} else {
								buf = "돈이없어용 ㅎㅎ".getBytes();
								packet = new DatagramPacket(buf, buf.length);
								socket.send(packet);
								System.out.println("돈이없어용 ㅎㅎ");
							}
						
					} else {
						buf = "계좌가 올바르지 않습니다".getBytes();
						packet = new DatagramPacket(buf, buf.length);
						socket.send(packet);
						System.out.println("ㄴ계좌");
					}

				} else if (msg.equals("이체")) {

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	private static Account findAccount(String ano) {

		for (int i = 0; i < account.size(); i++) {
			if (account.get(i).getAno().equals(ano)) {
				return account.get(i);
			}
		}
		return null;
	}
}
