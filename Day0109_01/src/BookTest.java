
public class BookTest {
	public static void main(String[] args) {
		Book[] book = new Book[4];
		
		book[0] = new Novel("978-89-6848-147-5","신용권","한빛미디어","이것이자바다");
		book[1] = new Poet("888-77-6666-555-4","인간","두빛미디어","이것이소설이다");
		book[2] = new ScienceFiction("977-78-5737-036-3", "중2", "우주출판사", "이것이공상과학이다");
		book[3] = new Novel("978-89-6848-147-5","신융권","한빚미디어","ㅇl것이자바다");
		
		for(Book b : book)
			System.out.println(b.day(3));
		
		//Book클래스는 추상클래스여서 추상메소드를 정의해줘야 사용할수 있다.
		Book bb = new Book("1","소설","소출","소책"){
			public int day(int d){
				return d*350;
			}
		};
		Novel novel = new Novel("1","소설","소설출판사","소설책");
		Poet poet = new Poet("2","시인","시출판사","시집");
		ScienceFiction science = new ScienceFiction("1","공상소설가","공상소설출판사","공상소설책");
//		
//		for(int i=0; i<book.length; i++)
//			System.out.println("book["+i+"]연체료: "+book[i].day(5));
//			
		if(novel.equals(science))
		System.out.println("같은책");
	}
}
