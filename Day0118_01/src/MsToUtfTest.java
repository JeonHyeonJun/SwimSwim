import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MsToUtfTest {
	public static void main(String[] args) {
		BufferedReader in = null;
		
		try{
			//디코딩이라는건 비트열이 문자데이터로 복원되는 과정
			//이 스트림은 이미 문자열스트림으로 기본세팅인 UTF-8이라 못씀
									//가공스트림				//변환할 문자스트림(Arraytest1.java)과 방식(MS949)
			in = new BufferedReader(new InputStreamReader(new FileInputStream("Arraytest1.java"), "MS949"));
			
			
			String msg = null;
			while ( (msg = in.readLine()) != null){
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
