
public class Subject {
	private int subjectcode;
	private String subjectname;
	private int number,attendance;
	
	public Subject(int c, String n, int num, int att){
		subjectcode = c;
		subjectname = n;
		number = num;
		attendance = att;
	}
	
	public int getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(int subjectcode) {
		this.subjectcode = subjectcode;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getAttendance() {
		return attendance;
	}
	public int setAttendance(int attendance) {
		this.attendance = attendance;
		return attendance;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return subjectcode+"\t"+ subjectname;
	}
	

	
	
	
}
