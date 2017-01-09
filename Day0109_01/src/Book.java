
public abstract class Book {		//추상클래스
	protected String isbn;
	protected String writer;
	protected String publisher;
	protected String title;

	
	public Book(String i, String w, String p, String t){
		i = isbn;
		w = writer;
		p = publisher;
		t = title;
	}
	
	//상속에서 부모클래스일 수록 추상적인 개념을 표현하기 때문에 추상적으로표현함.
	public abstract int day(int d);		//추상메소드
	
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Book){
			if(this.isbn.equals( ((Book)obj).isbn) )
				return true;
		}
		return false;
	}
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", publisher=" + publisher + ", writer=" + writer + ", title=" + title + "]";
	}
	

}
