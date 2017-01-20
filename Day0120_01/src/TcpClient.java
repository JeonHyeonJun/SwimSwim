import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	private static final String SERVER_IP = "70.12.111.105";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		BufferedWriter bw = null;
		BufferedReader br = null;

		try {
			socket = new Socket(SERVER_IP, SERVER_PORT);

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Thread sender = new Thread(new TcpSenderThread(bw));
			Thread receiver = new Thread(new TcpReceiverThread(br));
			
			sender.start();
			receiver.start();
			while(true){
				try{
					Thread.sleep(100);
					if(!sender.isAlive() || !receiver.isAlive())
						break;
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
				if (socket != null)
					socket.close();
				System.exit(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
