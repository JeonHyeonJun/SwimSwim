import java.net.Socket;

public class ThreadTest {
	public static void main(String[] args) {
		ThreadTcpReceiver receiver = new ThreadTcpReceiver();
		ThreadTcpSender sender = new ThreadTcpSender();
		Thread receiverThread = new Thread(receiver);
		Thread senderThread = new Thread(sender);

		receiverThread.start();
		senderThread.start();

	}
}
