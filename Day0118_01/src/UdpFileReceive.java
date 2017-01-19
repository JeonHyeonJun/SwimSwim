import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpFileReceive {
	public static void main(String[] args) {
		FileInputStream fi = null;
		FileOutputStream fo = null;
		DatagramSocket socket = null;
		
		try {
			fo = new FileOutputStream("wildlife_copy.wmv");
			socket = new DatagramSocket(5000);	//받는 포트번호 지정
			
			byte[] buf = new byte[1024*64];			//받을 빈 바이트배열 생성
			DatagramPacket packet = new DatagramPacket(buf, buf.length);	//받을 패킷 생성
			socket.receive(packet);	//여기서 대기타다가 패킷이 수신되면 빈패킷 객체가 보낸 패킷객체로 채워지고 빈바이트배열이 보낸 바이트배열로 채워짐
			System.out.println(packet.getAddress());
//			fi = new FileInputStream();
			int length;
			while((length = fi.read(buf)) != -1){
				fo.write(buf, 0, length);
			}
			
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			
		}
	}
}
