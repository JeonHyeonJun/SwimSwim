import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//바이트출력단위에서 문자출력단위로 변경하기
public class InputStreamReaderTest {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			while (!(msg = br.readLine()).equals("그만")) {
				System.out.println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
