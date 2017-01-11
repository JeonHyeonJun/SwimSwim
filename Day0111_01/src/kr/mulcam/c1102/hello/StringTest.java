package kr.mulcam.c1102.hello;

import java.util.Scanner;

public class StringTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String tmp,result;
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<5; i++){
			System.out.print(i+1+"번째 문자입력 ");
			tmp = scan.next();
			sb.append(tmp);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		
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
