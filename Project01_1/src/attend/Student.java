package attend;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Member implements Serializable{

	private List<Subject> subject = new ArrayList<Subject>();
	
	public List<Subject> getSubject() {
		return subject;
	}
	
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	public String getId() {
		return super.getID();
	}

	public String getPassword() {
		return super.getPass();
	}

	public Student(String id, String password, String name){
		if(id.length()<9)
			super.setID(id);
		if(password.length()<9)
			super.setPass(password);
		super.setName(name);
		subject = new ArrayList<Subject>();
	}


	
	public void add(int i, String string, int j, int k) {
		// TODO Auto-generated method stub
		subject.add(new Subject(i, string, j,k));
	}

	public void setnum(int code, int num){
		for(int i=0; i<subject.size(); i++)
			if(code==subject.get(i).getSubjectcode()){
				subject.get(i).setNumber(num);
			}
	}
	
	
	
}
