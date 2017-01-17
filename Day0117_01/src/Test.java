import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//영상파일복사하기
public class Test {
		public static void main(String[] args) {
			//wildlife.wmv
			FileOutputStream fo = null;
			FileInputStream fi = null;
			try {
				fo = new FileOutputStream("wildlife_copy.wmv");
				fi = new FileInputStream("wildlife.wmv");
				//여기부터 작업진행
				byte[] buf = new byte[1024*64];

				int length;
				long a = System.currentTimeMillis();
				while((length = fi.read(buf)) != -1){
					//read(byte[]) -> 매개변수로 들어온 바이트 배열크기만큼 읽어서 매개변수가 참조하는 배열에 읽은 내용을 채움.
					//				    읽어들인 길이를 정수로 반환
					//read(byte[],int,int) -> 첫번째 매개변수가 참조하는 바이트배열의 내용중 두번째 매개변수 만큼 skip하고 
					//						     세번째 매개변수만큼 바이트를 읽음
					fo.write(buf, 0 ,length);
					//write(byte[]) -> 매개변수가 참조하는 바이트 배열 내용을 출력
					//write(byte[],int,int) -> 첫번째 매개변수가 참조하는 바이트배열의 내용을 두번째 매개변수만큼 skip하고 
					//						       세번째 매개변수만큼 목적지에 출력
				}
				long b = System.currentTimeMillis();
				System.out.println(b-a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
