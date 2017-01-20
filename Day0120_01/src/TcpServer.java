import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			server = new ServerSocket(5000);
			socket = server.accept();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			
			
			Thread sender = new Thread(new TcpSenderThread(bw));
			Thread receiver = new Thread(new TcpReceiverThread(br));
			
			sender.start();
			receiver.start();
			
			while(true){
				try{
					Thread.sleep(100);
					if(!sender.isAlive() || !receiver.isAlive())	//sender,receiver중 하나라도 죽었으면 종료
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
				if (server != null)
					server.close();
				if (socket != null)
					socket.close();
				System.exit(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
