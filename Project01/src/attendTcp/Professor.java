package attendTcp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Member implements Serializable{
	private List<Subject> subject = new ArrayList<Subject>();
	private int attend;

	public Professor(){		
	}
	public Professor(String id, String password, String name){
		if(id.length()<9)
			super.setID(id);
		if(password.length()<9)
			super.setPass(password);
		super.setName(name);
		subject = new ArrayList<Subject>();	
	}
	
	public void setsubject(Subject subject) {
		this.subject.add(subject);
	}
	
	public int getsubjectSize(){
		return this.subject.size();
	}
	
//	public String getsubjectName(int subjectIndex){
//		return this.subject.get(subjectIndex).getsubjectName();
//	}
	
	public void add(int i, String string, int j, int k) {
		// TODO Auto-generated method stub
		subject.add(new Subject(i, string, j,k));
	}
	
	public String getId() {
		return super.getID();
	}

	public String getPassword() {
		return super.getPass();
	}
	public List<Subject> getSubject() {
		return subject;
	}

	
	public void setAttend() {
		this.attend = ((int)(Math.random() * 1000)) + 0;
	}
	public int getAttend() {
		return attend;
	}
}
