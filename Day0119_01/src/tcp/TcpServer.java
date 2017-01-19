package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket clientSocket = null;
		BufferedReader input = null;
		BufferedWriter output = null;
		
		try {
			server = new ServerSocket(5000);
			clientSocket = server.accept();	//accept가 호출되면 명령처리흐름이 멈춰서 클라의 연결요청을 기다림
											//연결요청이 들어오고 잘되면 accept의 반환값으로 클라랑 연결되있는 소켓객체 튀어나옴

			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));		//읽고
			output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));	//쓰기

			output.write("Hello World! \n");
			output.flush();
			String msg = input.readLine();
			System.out.println(msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (input != null)
					input.close();
				if (output != null)
					output.close();
				if (server != null)
					server.close();
				if (clientSocket != null)
					clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
