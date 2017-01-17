import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamTest {
	public static void main(String[] args) {
		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		try {
			int c;
			out = new BufferedOutputStream(new FileOutputStream("wildlife_copy.wmv"));
			in = new BufferedInputStream(new FileInputStream("wildlife.wmv"));
			byte[] buf = new byte[1024*64];
			
			int length;
//			for (int i = 0; i < in.read(); i++) {
//				out.write(i);
//			}

//			out.flush();	//Buffered방식은 buffer가 꽉차야 출력을 하는데 아직 안 찬 바가지를 채우는 명령이 flush
			while ((length = in.read(buf)) != -1) {
				out.write(buf,0,length);
//				System.out.println(c + " ");
			}
			out.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
