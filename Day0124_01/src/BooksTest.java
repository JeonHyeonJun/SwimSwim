import java.util.Scanner;

public class BooksTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BooksDao book = BooksDao.getInstance();
		
		boolean run = true;
		
		while(run){
			System.out.println("==========================");
			System.out.println("1.추가|2.수정|3.삭제|4.조회|5.종료");
			System.out.println("==========================");
			System.out.print("선택> ");
			int select = scan.nextInt();
			
			if(select == 1){
				System.out.print("제목 ");
				String title = scan.next();
				System.out.print("출판사 ");
				String publisher = scan.next();
				System.out.print("출판연도 ");
				String year = scan.next();
				System.out.print("가격 ");
				int price = scan.nextInt();
				book.insert(title,publisher,year,price);
				
			} else if (select == 2){
				System.out.print("수정할 가격 ");
				int price = scan.nextInt();
				System.out.print("제목 ");
				String title = scan.next();
				System.out.print("출판사 ");
				String publisher = scan.next();
				book.update(title,publisher,price);
			
			} else if (select == 3){
				System.out.print("출판연도 ");
				String year = scan.next();
				book.delete(year);
				
			} else if (select == 4){
				for(int i = 0; i<book.selectAll().size(); i++)
				System.out.println(book.selectAll().get(i));
			} else if (select == 5){
				run = false;
				System.out.println("종료Death!");
				book.close();
			}
		}
	}
}
