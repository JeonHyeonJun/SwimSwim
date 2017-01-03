
public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		
		b1.setTitle("이것이자바다");
		b2.setTitle("데스노트");
		
		b1.setPrice(18000);
		b2.setPrice(3000);
		
		b1.setPubYear(1993);
		b2.setPubYear(1990);
		
		b1.setAutor("신용권");
		b2.setAutor("일본사람");
		
		b1.setPublisher("한빛미디어");
		b2.setPublisher("어딘가");
		
		System.out.println(b1);
		System.out.println(b2);
	}
}
