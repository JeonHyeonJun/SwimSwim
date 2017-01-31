package server;

import java.util.List;

import protocol.Professor;
import protocol.Student;
import protocol.Student_Subject;
import protocol.Subject;

public class AttendService {
	private AttendDao ad; 
	
	public AttendService(){
		ad = AttendDao.getInstance();	
	}
	
	public boolean st_login(String id, String ps){
		Student st = ad.st_login(id, ps);
		if(st != null)
			return true;
		else
			return false;
	}
	
	public boolean pr_login(String id, String ps){
		Professor pr = ad.pr_login(id, ps);
		if(pr != null)
			return true;
		else
			return false;
	}
	
	public List<Subject> st_subjectlist(String id, String ps){
		Student st = ad.st_login(id, ps);
		List<Subject> sub = ad.st_subjectlist(st.getStnumber());
		return sub;
	}
	
	public List<Subject> pr_subjectlist(String id, String ps){
		Professor pr = ad.pr_login(id, ps);
		List<Subject> sub = ad.pr_subjectlist(pr.getPrnumber());
		return sub;
	}
	
	public boolean st_subjectselect(String id, String ps, String subnumber){
		Student st = ad.st_login(id, ps);
		List<Subject> sub = ad.st_subjectlist(st.getStnumber());
		for(int i=0; i<sub.size(); i++){
			String temp = sub.get(i).getSubnumber();
			if(temp.equals(subnumber))
				return true;
		}
		return false;
	}
	
	public boolean pr_subjectselect(String id, String ps, String subnumber){
		Professor pr = ad.pr_login(id, ps);
		List<Subject> sub = ad.pr_subjectlist(pr.getPrnumber());
		for(int i=0; i<sub.size(); i++){
			String temp = sub.get(i).getSubnumber();
			if(temp.equals(subnumber))
				return true;
		}
		return false;
	}

	public int st_attend(String subnumber, int attnumber, int fail){
		Subject sub = ad.attendnumberOk(subnumber, attnumber);
		if(sub.getSubAttendnumber() != 0 && sub.getSubAttendnumber() == attnumber){
			ad.updateAttendNumber(0, subnumber);
			return 1;
		}
		else if(fail == 3)
			return 3;
		else
			return 2;
	}
	
	public int pr_attend(String subnumber){
		int num = (int)(Math.random()*100)+1;
		ad.updateAttendNumber(num, subnumber);
		return num;
	}
	
	public int attendsuccess(String id, String ps, String subnumber){
		Student st = ad.st_login(id, ps);
		Student_Subject stsub = ad.student_subject(st.getStnumber(), subnumber);
		int a = stsub.getAttendnumber();
		stsub.setAttendnumber(a+1);
		a = stsub.getAttendnumber();
		ad.updateStudentAttend(a, st.getStnumber(), subnumber);
		return a;
	}
}
