package kr.mulcam.c1102.hello;

import java.util.Scanner;

//사용자한테 숫자를 두개 입력받아서 두 수의 합을 출력하는 프로그램작성
//Scanner클래스의 next()메소드를 이용해서 입력

public class Sum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = Integer.parseInt(scan.next());	//형변환, 문자를 int로 바꿔줌(맞나?)
		int b = Integer.parseInt(scan.next());
		int c = a+b;
		
		System.out.println(c);
		
	}
}
