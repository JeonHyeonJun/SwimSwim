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
import java.util.ArrayList;
import java.util.List;

public class BankApplicationServer {
	private static final String SEVER_IP = "70.12.111.105";
	private static final int SEVER_PORT = 5001;
	private static final int SEVER_PORT2 = 5002;
	static BufferedWriter bw = null;
	static BufferedReader br = null;
	static ServerSocket server = null;
	static Socket socket = null;
	static List<Account> account = new ArrayList<Account>();

	public static void main(String[] args) {

		try {
			server = new ServerSocket(SEVER_PORT);
			socket = server.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String msg = null;
				msg = br.readLine();

				if (msg.equals("계좌생성")) {
					
					System.out.println("계좌를생성합니다.");

					String[] money = new String[3];
					for (int i = 0; i < money.length; i++) {
						msg = br.readLine();
						money[i] = msg;
					}
					account.add(new Account(money[0], money[1], Integer.parseInt(money[2])));
					System.out.println(account);

					

				} 
				else if (msg.equals("계좌리스트")) {
					socket = new Socket(SEVER_IP, SEVER_PORT2);
					System.out.println("계좌목록을 보여줍니다");
					// buf = account.toString().getBytes();
					// for(int i=0; i<account.size(); i++){
					// buf = account.get(i).toString().getBytes();
					bw.write(account.toString()+"\n");
					bw.flush();
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
						msg = br.readLine();
					}
						if (findAccount(tmp[0]) != null) {
							int money = Integer.parseInt(tmp[1]);
							findAccount(tmp[0]).setBalance(findAccount(tmp[0]).getBalance() + money);

							String m = String.valueOf(findAccount(tmp[0]).getBalance());
//							bw.write(m);
//							bw.flush();
							System.out.println(m);
							System.out.println("전송완료");
						} else {
//							bw.write("계좌가올바르지 않습니다");
//							bw.flush();
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
						br.readLine();
					}
						if (findAccount(tmp[0]) != null) {
							int money = Integer.parseInt(tmp[1]);
							if (findAccount(tmp[0]).getBalance() - money >= 0) {
								findAccount(tmp[0]).setBalance(findAccount(tmp[0]).getBalance() - money);

								String m = String.valueOf(findAccount(tmp[0]).getBalance());
								bw.write(m);
								bw.flush();
								
							} else {
								bw.write("돈이없어용 ㅎㅎ");
								bw.flush();
								System.out.println("돈이없어용 ㅎㅎ");
							}
						
					} else {
						bw.write("계좌가올바르지 않습니다");
						bw.flush();
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
