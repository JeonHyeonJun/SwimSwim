package kr.mulcam.c1102.hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String s;
		System.out.println("yyyy-MM-dd hh:mm:ss 로 입력");
		s = scan.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		
		try { 
			Date d = sdf.parse(s); 
			System.out.println(d);
			long miliTime = d.getTime();
			System.out.println(miliTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		Date d2 = sdf.parse(d);
	}
	
}
