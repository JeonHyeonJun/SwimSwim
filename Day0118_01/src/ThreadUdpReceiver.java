import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ThreadUdpReceiver extends Thread{
	
	public void run(){
		DatagramSocket socket = null;
		boolean run = true;
		
		try {
			socket = new DatagramSocket(5000);	//받는 포트번호 지정
			while(run){
			byte[] buf = new byte[512];			//받을 빈 바이트배열 생성
			DatagramPacket packet = new DatagramPacket(buf, buf.length);	//받을 패킷 생성
			socket.receive(packet);	//여기서 대기타다가 패킷이 수신되면 빈패킷 객체가 보낸 패킷객체로 채워지고 빈바이트배열이 보낸 바이트배열로 채워짐
			if(!buf.equals("시발") && !buf.equals("10")){
			System.out.println(new String(buf)); //받은 바이트배열 출력
			System.out.println(packet.getAddress());
			} else {
				System.out.println("****");
			}
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			
		}
	}
}
