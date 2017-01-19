import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpFileSender {
	public static void main(String[] args) {
		FileInputStream fi = null;
//		FileOutputStream fo = null;
		DatagramSocket socket = null; // 소켓생성

		// IO가 발생할수있으니 예외처리
		try {
//				fo = new FileOutputStream("c:/wildlife_copy.wmv");
				fi = new FileInputStream("wildlife.wmv");
				
				socket = new DatagramSocket();
				byte[] buf = new byte[1024*64]; // 바이트배열 데이터 생성
				DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("70.12.111.100"),	5000);
				int length;
				while((length = fi.read(buf)) != -1){
//					fo.write(buf, 0, length);
					socket.send(packet);
				}
//				socket.send(packet);
				
				
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
			try{
//			if(fo != null)
//				fo.close();
			if(fi != null)
				fi.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
