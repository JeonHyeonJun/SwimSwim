package protocol;

import java.io.Serializable;

public class Student_Subject implements Serializable{
	private String stnumber;
	private String subnumber; 
	private int attendnumber;
	public String getStnumber() {
		return stnumber;
	}
	public void setStnumber(String stnumber) {
		this.stnumber = stnumber;
	}
	public String getSubnumber() {
		return subnumber;
	}
	public void setSubnumber(String subnumber) {
		this.subnumber = subnumber;
	}
	public int getAttendnumber() {
		return attendnumber;
	}
	public void setAttendnumber(int attendnumber) {
		this.attendnumber = attendnumber;
	}
	@Override
	public String toString() {
		return "Student_Subject [stnumber=" + stnumber + ", subnumber=" + subnumber + ", attendnumber=" + attendnumber
				+ "]";
	}
	
	
}
