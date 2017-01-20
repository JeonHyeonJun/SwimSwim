import java.io.BufferedReader;
import java.io.IOException;

public class TcpReceiverThread implements Runnable {
	private BufferedReader br;

	public TcpReceiverThread(BufferedReader br) {
		// TODO Auto-generated constructor stub
		this.br = br;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			while ((msg = br.readLine()) != null) {
				if( msg.equals("quit"))
					break;
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
