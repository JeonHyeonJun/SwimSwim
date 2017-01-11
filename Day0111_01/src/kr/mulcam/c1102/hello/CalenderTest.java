package kr.mulcam.c1102.hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//yyyy-MM-dd hh:mm:ss
public class CalenderTest {
	public static void main(String[] args) {
		Date d = new Date();
		//yyyy-MM-dd로 출력하긔
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		//yyyy-MM-dd를 시간객체로 변환
		try {
			Date d2 = sdf.parse("1999-03-20 11:11:11");
			System.out.println(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Calendar d = Calendar.getInstance();
//		System.out.println(d);
//		System.out.println(d.get(Calendar.YEAR)+"년");
//		System.out.println(d.get(Calendar.MONTH)+1+"월");
//		System.out.println(d.get(Calendar.DATE)+"일");
//		
//		d.set(Calendar.HOUR, 12);
//		d.set(Calendar.MINUTE, 34);
//		d.set(Calendar.SECOND,0);
//		System.out.println(d);
	}
}
