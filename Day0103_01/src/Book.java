
public class Book {
	private String title; //제목
	private int price; //가격
	private String publisher; //출판사
	private String autor; //저자
	private int pubYear; //출판년도
	
	
	public void setTitle(String t){
		title = t;
	}
	public String getTitle(){
		return title;
	}
	
	public void setPrice(int t){
		price = t;
	}
	public int getPrice(){
		return price;
	}
	
	public void setPublisher(String t){
		publisher = t;
	}
	public String getPublisher(){
		return publisher;
	}
	
	public void setAutor(String t){
		autor = t;
	}
	public String getAutor(){
		return autor;
	}
	
	public void setPubYear(int t){
		pubYear = t;
	}
	public int getPubYear(){
		return pubYear;
	}
	
	public String toString(){
		return "제목 : " +getTitle()+ " 가격 : " +getPrice()+ " 출판사 : " +getPublisher()+ " 저자 : " +getAutor()+ " 출판년도 : " +getPubYear();
	}
}
