package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TcpClient {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			socket = new Socket("70.12.111.106", 5000);
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String msg = br.readLine();
			System.out.println(msg);
			bw.write("Nice boat!");
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( br != null)
					br.close();
				if( bw != null)
					bw.close();
				if(socket != null)
					socket.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
