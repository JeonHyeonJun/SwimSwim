package protocol;
import java.io.Serializable;

public class Subject implements Serializable{
	private String subnumber;
	private String subname;
	private String prnumber;
	private int subAttendnumber; 
	public String getSubnumber() {
		return subnumber;
	}
	public void setSubnumber(String subnumber) {
		this.subnumber = subnumber;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getPrnumber() {
		return prnumber;
	}
	public void setPrnumber(String prnumber) {
		this.prnumber = prnumber;
	}
	public int getSubAttendnumber() {
		return subAttendnumber;
	}
	public void setSubAttendnumber(int subAttendnumber) {
		this.subAttendnumber = subAttendnumber;
	}
	@Override
	public String toString() {
		return "Subject [subnumber=" + subnumber + ", subname=" + subname + ", prnumber=" + prnumber
				+"]";
	}
	
	
}
