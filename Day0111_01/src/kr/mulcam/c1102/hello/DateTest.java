package kr.mulcam.c1102.hello;

import java.util.*;

public class DateTest {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		System.out.println(1900+d.getYear());
		System.out.println(d.getMonth()+1);
		System.out.println(d.getDate());
		
		d.setHours(12);
		d.setMinutes(34);
		d.setSeconds(0);
		System.out.println(d);
		
		long current = System.currentTimeMillis();
		Date date = new Date(current);
		System.out.println(date);
		current = date.getTime();
		
		System.out.println(date.getYear());	//depercated된함수 왠만하면 안쓰는게 좋다
	}
}
