import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ThreadUdpSender extends Thread{
	

	// IO가 발생할수있으니 예외처리
	public void run(){
		Scanner scan = new Scanner(System.in);
		DatagramSocket socket = null;
	try {
		String mal = "";
		while (!mal.equals("그만ㅋ")) {
			mal =scan.nextLine();
			socket = new DatagramSocket();
			byte[] buf = mal.getBytes(); // 바이트배열 데이터 생성
			DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("70.12.111.90"),
					5000);
			// 보낼바이트배열,보낼데이터길이,받는사람IP주소(InetAddress),받는사람포트번호

			socket.send(packet); // 보내기
		}
	} catch (IOException e) {
		e.printStackTrace();
	} finally {

	
	}
}
}
