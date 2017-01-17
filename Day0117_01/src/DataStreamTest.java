import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	public static void main(String[] args) {
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.bin")));
			in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.bin")));
			
			out.writeDouble(3.14);
			out.writeInt(100);
			out.writeUTF("현실못바꿈");
			out.flush();
			
			System.out.println(in.readDouble());
			System.out.println(in.readInt());
			System.out.println(in.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
				try {
					if(out != null)
						out.close();
					if(in != null)
						in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
