import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
	public static void main(String[] args) {
		FileOutputStream fo = null;
		FileInputStream fi = null;
		
		try{
			fo = new FileOutputStream("C:/data.txt");	//파일경로 및 파일이름
			fi = new FileInputStream("C:/data.txt");
			//요 구간에서 필요한 IO작업 수행 ㄱ
			
			for( int i = 0; i<300; i++)
				fo.write(i);	//write는 바이트값을 기록
								//바이트의 최대값은 255이므로 255까지출력하고 다시 0부터출력
			
			int c;
			while((c = fi.read()) != -1){	
				System.out.println(c);
				//read메소드는 목적지로부터 1바이트를 읽고 더이상 읽을값이 없으면 -1을 리턴
			}
		} catch(IOException e) {
			
		} finally {
			try {
				if(fo != null)
					fo.close();
				if(fi != null)
					fi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}