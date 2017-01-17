import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		String name = "C:/Users/student/Downloads/eclipse";
		File dir = new File(name);
		String[] fileNames = dir.list();	//현재 디렉토리의 전체 파일 리스트
		for(String s : fileNames){
			File f = new File(name + "/" + s);
			System.out.println("===========================");
			System.out.println("이름: " +f.getName());
			System.out.println("경로: " +f.getPath());
			System.out.println("부모: " +f.getParent());
			System.out.println("절대경로: " +f.getAbsolutePath());
			try {
				System.out.println("정규경로: " +f.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("디렉토리 여부: " +f.isDirectory());	//폴더인가
			System.out.println("파일 여부: " +f.isFile());			//파일인가
			System.out.println("===========================");
		}
	}
}
