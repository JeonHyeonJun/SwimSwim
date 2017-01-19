package server;
 
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
 
public class GilsunServer {
	static List<Account> list = new ArrayList<Account>();
	private static final String SERVER_IP = "70.12.111.100";
	private static final int SERVER_PORT = 4003;
	private static DatagramSocket socket = null;
	private static DatagramPacket packet = null;
	private static byte[] buf = null;
 
	public static void main(String[] args) {
 
		try {
			socket = new DatagramSocket(4003);
			while (true) {
				receive();
				String msg = new String(buf).trim();
				if (msg.equals("계좌생성")) {
					System.out.println("계좌생성이 시작되었습니다.");
					receive();
					String ano = new String(buf).trim();
					System.out.println(ano);
					if (findAccount(ano) != null) {
						System.out.println("중복된 계좌번호 입니다.");
						String str = "중복";
						buf = str.getBytes();
						send();
					} else {
						String str = "계속";
						buf = str.getBytes();
						send();
						String[] tmp = new String[2];
						for (int i = 0; i < 2; i++) {
							receive();
							tmp[i] = new String(buf).trim();
							System.out.println(tmp[i]);
						}
 
						int balance = Integer.parseInt(tmp[1]);
 
						Account account = new Account(ano, tmp[0], balance);
						list.add(account);
 
						String anoComplete = "계좌가 생성되었습니다.";
						buf = anoComplete.getBytes();
						send();
					}
				} else if (msg.equals("계좌리스트")) {
					System.out.println("계좌리스트를 전송합니다.");
					for (int i = 0; i < list.size(); i++) {
						buf = new byte[1024]; 
						buf = list.get(i).toString().getBytes(); 
						packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SERVER_IP), SERVER_PORT);
						socket.send(packet);
					}
					String exit = "종료";
					buf = exit.getBytes();
					packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SERVER_IP), SERVER_PORT);
					socket.send(packet);
 
				} else if (msg.equals("입금")) {
					System.out.println("입금이 시작되었습니다.");
					receive();
					String ano = new String(buf).trim();
					System.out.println(ano);
					Account account = findAccount(ano);
					if (account != null) {
						System.out.println("입금 시작");
 
						receive();
						String accept = new String(buf);
						int deposit = Integer.parseInt(accept);
						int result = findAccount(ano).getBalance() + deposit;
 
						account.setBalance(result);
						System.out.println("입금이 완료되었습니다.");
					} else {
						System.out.println("계좌번호 틀림");
					}
 
				} else if (msg.equals("출금")) {
					System.out.println("출금이 시작되었습니다.");
					receive();
					String ano = new String(buf).trim();
					System.out.println(ano);
					Account account = findAccount(ano);
					if (account != null) {
						System.out.println("출금 시작");
						receive();
						String accept = new String(buf);
						int withdraw = Integer.parseInt(accept);
						int result = findAccount(ano).getBalance() - withdraw;
 
						account.setBalance(result);
						System.out.println("출금이 완료되었습니다.");
					} else {
						System.out.println("계좌번호 틀림");
					}
				} else if (msg.equals("이체")) {
					System.out.println("이체가 시작되었습니다.");
					String tmp[] = new String[3];
					for (int i = 0; i < 3; i++) {
						receive();
						tmp[i] = new String(buf);
					}
					int balance = Integer.parseInt(tmp[2]);
 
					Account account = findAccount(tmp[0]);
					Account account2 = findAccount(tmp[1]);
					if (account == null || account2 == null) {
						System.out.println("두 계좌중 하나가 없는 계좌입니다.");
					} else {
						account2.setBalance(account2.getBalance() + balance);
						account.setBalance(account.getBalance() - balance);
					}
				}
 
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
 
	public static Account findAccount(String ano) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAno().equals(ano))
				return list.get(i);
		}
		return null;
	}
 
	public static void receive() {
		try {
			buf = new byte[1024];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void send() {
		try {
			packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(SERVER_IP), SERVER_PORT);
			socket.send(packet);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 
}
