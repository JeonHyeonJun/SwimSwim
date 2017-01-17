import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.Scanner;

//문자단위로 파일읽기
public class FileReaderTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try{
			//사용자로부터 문자열을 계속 입력받다가 그만ㅋ 라고 입력하면 종료
			//모든 문자열은 파일에 저장
			String s = "";
			final String STOP = "그만ㅋ";
			bw = new BufferedWriter(new FileWriter("test1.txt"));
			br = new BufferedReader(new FileReader("test1.txt"));
			
			while(!(s=scan.nextLine()).equals(STOP)){
				bw.write(s + "\n");
			}
//			bw.write("아 슈발 꿈 \n");
//			bw.write("Ah Shubal Kkum \n");
//			bw.write("읭읭 \n");
			bw.flush();
			
			String msg = null;
			while((msg = br.readLine()) != null){
				System.out.print(msg);
			}
		} catch(IOException e){
		} finally {
				try {
					if(bw != null)
						bw.close();
					if(br != null)
						br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		
		
		//FileReader예제
//		FileReader in = null;
//		FileWriter out = null;
//		
//		String s = "꿈에 미치면 꿈은 이루어진다";
//		
//		try {
//			out = new FileWriter("test.txt");
//			in = new FileReader("test.txt");
//			
//			out.write(s);
//			out.append('.');
//			out.flush();
//			
//			int c;
//			while((c = in.read()) != -1){
//				System.out.print((char)c);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//				try {
//					if(out != null)
//						out.close();
//					if(in != null)
//						in.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
	}
}
