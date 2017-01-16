import java.util.ArrayList;
import java.util.List;

public class Student {
	private String id,passward,name;
	private List<Subject> subject = new ArrayList<Subject>();
	
	public List<Subject> getSubject() {
		return subject;
	}
	
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	public String getId() {
		return id;
	}

	public String getPassward() {
		return passward;
	}
	
	
	

	public Student(String id, String passward, String name){
		if(id.length()<9)
			this.id = id;
		if(passward.length()<9)
			this.passward = passward;
		this.name = name;
		subject = new ArrayList<Subject>();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", passward=" + passward + ", name=" + name + ", subject=" + subject
				+  "]";
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
