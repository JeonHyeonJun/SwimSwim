import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadTcpSender implements Runnable {

	private static final String SERVER_IP = "70.12.111.105";
	private static final int SERVER_PORT = 5000;

	public void run() {
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		BufferedWriter bw = null;

		try {
			socket = new Socket(SERVER_IP, SERVER_PORT);

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while (true) {
				String msg = scan.nextLine();
				bw.write(msg + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
