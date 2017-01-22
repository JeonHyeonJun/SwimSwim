package attendTcp;

import java.io.Serializable;

public class Subject implements Serializable{
	private int subjectcode;
	private String subjectname;
	private int number,attendance;
	
	public Subject(int c, String n, int num, int att){
		subjectcode = c;	//怨쇰ぉ踰���
		subjectname = n;	//怨쇰ぉ�대�
		number = num;		//怨쇰ぉ異���踰���
		attendance = att;	//怨쇰ぉ異�������
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
	public int setNumber(int number) {
		this.number = number;
		return number;
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
