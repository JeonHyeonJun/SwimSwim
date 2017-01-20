package protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;

		try {
			server = new ServerSocket(5000);
			socket = server.accept();
			out = new ObjectOutputStream(socket.getOutputStream());	//out을 먼저 만들긔!
			in = new ObjectInputStream(socket.getInputStream());
			
			Message msg = new Message();
			msg.setCode(1);
			msg.setMsg("Hello");
			out.writeObject(msg);
			out.flush();
			Message rMsg = (Message) in.readObject();
			System.out.println(rMsg);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
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
