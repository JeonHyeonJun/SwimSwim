
public class BookTest {
	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		
		b1.setTitle("�̰����ڹٴ�");
		b2.setTitle("������Ʈ");
		
		b1.setPrice(18000);
		b2.setPrice(3000);
		
		b1.setPubYear(1993);
		b2.setPubYear(1990);
		
		b1.setAutor("�ſ��");
		b2.setAutor("�Ϻ����");
		
		b1.setPublisher("�Ѻ��̵��");
		b2.setPublisher("���");
		
		System.out.println(b1);
		System.out.println(b2);
	}
}
