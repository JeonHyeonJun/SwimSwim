import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadTcpReceiver implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader br = null;

		try {
			server = new ServerSocket(5000);
			socket = server.accept();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String msg = br.readLine();
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (server != null)
					server.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
