package kr.mulcam.c1102.hello;

import java.util.Scanner;

public class StringTest {
	public static void main(String[] args) {
		//문자 삽입,삭제,변경하기 StringBuilder 
		StringBuilder sb = new StringBuilder();
		
		sb.append("Java ");						//문자열끝에 Java 추가
		sb.append("Program 굿굿");				//문자열끝에 Program 굿굿 추가
		System.out.println(sb.toString());		//sb 출력
		
		sb.insert(4, "2");						//4번째문자 뒤에 2삽입
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');					//4번째문자 뒤의 문자를 6으로 변경
		System.out.println(sb.toString());
		
		sb.replace(6, 13, "Game");				//6번째문자 뒤부터 13번째문자까지 Game 문자열로 대치
		System.out.println(sb.toString());
		
		sb.delete(3, 5);						//3번째문자 뒤부터 5번째문자까지 삭제
		System.out.println(sb.toString());
		
		int length = sb.length();				//length에 sb에 저장된 총 문자수 대입
		System.out.println("총문자수 : " +length);	
		
		String result = sb.toString();			//String 타입으로 반환한것을 result에 대입
		System.out.println(result);
		
		//StringBuffer
//		Scanner scan = new Scanner(System.in);
//		String tmp,result;
//		
//		StringBuffer sb = new StringBuffer();
//		
//		for(int i=0; i<5; i++){
//			System.out.print(i+1+"번째 문자입력 ");
//			tmp = scan.next();
//			sb.append(tmp);
//			sb.append(",");
//		}
//		sb.deleteCharAt(sb.length()-1);
//		System.out.println(sb.toString());
		
		
		//StringBuilder
//		String[] a = new String[5];
//		
//		for(int i=0; i<a.length; i++){
//			System.out.print(i+1+"번째 문자입력 : ");
//			a[i] = scan.next();
//		}
//		StringBuilder builder = new StringBuilder();
//		
//		for(int i=0; i<a.length; i++){
//			builder.append(a[i]+",");
//		}
//		System.out.println(builder);
	}
}
