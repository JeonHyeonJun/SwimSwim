package kr.mulcam.c1102.hello;

import java.util.Scanner;
import java.util.StringTokenizer;

//사용자로부터 id와 pw을 id//pw 형태로 입력받아서 id와 pw를 나누어 출력하는 프로그램을 작성
public class IdPasswardTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("id//passward 입력");
		String idps = scan.next();
		
		StringTokenizer st = new StringTokenizer(idps,"//"); //분리된 문자열에 갯수를 Token으로 저장?
		
		if(st.countTokens()==2){	//분리된 문자열에 갯수가 2개일때 true
			System.out.println("id : " +st.nextToken());
			System.out.println("비번 : " +st.nextToken());
		}
	}
}
