package kr.mulcam.c1102.hello;

import java.util.Scanner;	//java.util.Scanner라는 클래스를 같은 패키지에 있는 것처럼 사용하기위한 import선언
import java.util.*;			//java.util패키지에 있는 클래스를 import

public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);	//기본적으로 그냥 클래스명을 적으면 같은 패키지에 있는걸 말하고 여기에 없으니 에러
		java.util.Scanner scan2 = new java.util.Scanner(System.in);	//import 안하고 부를땐 이렇게!
		
		System.out.println("??");	//System 클래스는 java.lang에 들어있어서 안불러도 쓸수있음
									//java.lang은 자바프로긂이 동작하기 위한 최소한의 기능들(클래스들)모임 import 안해도 사용가능
		
	}
}
