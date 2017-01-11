package kr.mulcam.c1102.hello;

import java.util.StringTokenizer;

public class StringTest2 {
	public static void main(String[] args) {
		//StringTokenizer로 문자열 분리하기
		String text = "홍길동/이수연/박연수";
		
		//for문으로 출력하기
		StringTokenizer st = new StringTokenizer(text, "/");	//분리된 문자열 수만큼 토큰생성
		int count = st.countTokens();							//토큰수를 count에 저장
		for(int i=0; i<count; i++){								//0부터 토큰수까지 진행
			String t = st.nextToken();							//토큰을 하나 꺼내고 꺼낸토큰 t에 저장
			System.out.println(t);								//꺼낸 토큰있는 t출력
		}
		//while문으로 출력하기
		StringTokenizer st2 = new StringTokenizer(text, "/");
		while(st2.hasMoreTokens()){								//토큰이 남아있다면 진행
			System.out.println(st2.nextToken());
		}
		
		
		//split()메소드로 문자열 분리하기
//		String text = "홍길동&이수홍,박연수,김자바-최명호";
//		
//		String[] names = text.split("&|,|-");
//		
//		for(String name : names){
//			System.out.println(name);
//		}
		
		
		//StringTokenizer클래스로 문자열 분리하기
//		StringTokenizer st = new StringTokenizer("Will Java change my life");
//		while (st.hasMoreTokens()){
//			System.out.println(st.nextToken());
//		}
		
		
		//split()메소드로 문자열 분리하기
//		String str = "Will Java change my life";
//		String[] results = str.split(" ");
//		
//		for(String s : results)
//			System.out.println(s);
	}
	
	
	
}
