import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class TcpSenderThread implements Runnable {
	private BufferedWriter bw;

	public TcpSenderThread(BufferedWriter bw) {
		// TODO Auto-generated constructor stub
		this.bw = bw;
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			while (true) {
				String msg = scan.nextLine();
				bw.write(msg + "\n");
				bw.flush();
				if(msg.equals("quit"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
