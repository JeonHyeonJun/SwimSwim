
public class Chatting {
	public static void main(String[] args) {
		ThreadUdpSender sender = new ThreadUdpSender();
		ThreadUdpReceiver receiver = new ThreadUdpReceiver();
		
		receiver.start();
		sender.start();
	}
}
