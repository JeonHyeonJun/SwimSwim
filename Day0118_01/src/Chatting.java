import java.io.IOException;
import java.net.DatagramSocket;

public class Chatting {
	public static void main(String[] args) {
		DatagramSocket socket = null;
		
		try{
			socket = new DatagramSocket(5000);
			ThreadUdpSender sender = new ThreadUdpSender(socket);
			ThreadUdpReceiver receiver = new ThreadUdpReceiver(socket);
			Thread senderThread = new Thread(sender);
			Thread receiverThread = new Thread(receiver);
			
			senderThread.start();
			receiverThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
