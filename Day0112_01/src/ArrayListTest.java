import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		//4개다 쓸수있다
//		ArrayList<String> list = new ArrayList<String>();
//		LinkedList<String> list = new LinkedList<String>();
//		List<String> list = new ArrayList<String>();
		List<String> list = new LinkedList<String>();
		
		list.add("우유");		//{우유}
		list.add("빵");		//{우유,빵}
		list.add("뻐터");		//{우유,빵,뻐터}
		list.add(1, "사과");	//인덱스1에 "사과" 삽입{우유,사과,빵,뻐터}
		list.set(2, "뽀도");	//인덱스2의 원소를 "뽀도"로 대체{우유,사과,뽀도,뻐터}
		list.remove(3);		//인덱스3의 원소 삭제{우유,사과,뽀도}
		
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		//같은결과 Iterator문
		Iterator<String> e = list.iterator();
		while(e.hasNext()){
			System.out.println(e.next());
		}
		
//		for(int i=0; i<list.size(); i++)
//			System.out.println(list.get(i));
		
	}
}
