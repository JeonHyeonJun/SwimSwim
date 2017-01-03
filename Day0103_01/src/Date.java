
public class Date{
	private int year;
	private String month;
	private int day;
	
	public Date(){
		month = "1¿ù";
		day = 1;
		year = 2009;
	}
	
	public Date(int year, String month, int day){
		setDate(year, month, day);
	}
	
	public Date(int year){
		setDate(year, "1¿ù",1);
	}
	
	public void setDate(int year, String month, int day){
		this.month = month;
		this.day = day;
		this.year = year;
	}
}

