package kr.mulcam.c1102.hello;

import java.util.StringTokenizer;

public class StringTest2 {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("Will Java change my life");
		while (st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
	}
}
