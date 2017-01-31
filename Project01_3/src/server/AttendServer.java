package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AttendServer {
	public static void main(String[] args) {
		ServerSocket server;
		
		try {
			server = new ServerSocket(5000);
			Socket socket = server.accept();
			
			AttendServerThread attendserver = new AttendServerThread(socket);
			Thread t = new Thread(attendserver);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
