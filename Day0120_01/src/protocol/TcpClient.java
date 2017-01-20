package protocol;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	public static void main(String[] args) {
		Socket socket = null;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		
		try{
			socket = new Socket("70.12.111.105", 5000);

			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

			Message sMsg = (Message) in.readObject();
			if(sMsg.getCode() == 1){
				System.out.println("서버가 인사를 하네: " +sMsg.getMsg());
				System.out.println("인사를하겠으면 1번 싸우겠으면 2번");
				int select = new Scanner(System.in).nextInt();
				Message msg = new Message();
				if( select ==1 ){
					msg.setCode(0);
					msg.setMsg("Halo~");
				} else {
					msg.setCode(1);
					msg.setMsg("덤벼");
				}
				out.writeObject(msg);
				out.flush();
			}
		} catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
