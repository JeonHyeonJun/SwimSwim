
public class Book {
	private String title; //����
	private int price; //����
	private String publisher; //���ǻ�
	private String autor; //����
	private int pubYear; //���ǳ⵵
	
	
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
		return "���� : " +getTitle()+ " ���� : " +getPrice()+ " ���ǻ� : " +getPublisher()+ " ���� : " +getAutor()+ " ���ǳ⵵ : " +getPubYear();
	}
}
