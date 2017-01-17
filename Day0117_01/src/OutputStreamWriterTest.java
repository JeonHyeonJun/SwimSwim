import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

//바이트출력단위에서 문자출력단위로 변경하기
public class OutputStreamWriterTest {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
		writer.write(data);
		
		writer.flush();
		writer.close();
		System.out.println("파일저장");
	}
}
