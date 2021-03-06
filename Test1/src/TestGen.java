import java.util.ArrayList;
import java.util.List;


public class TestGen {

	static class Student implements Comparable<Student>{
		int grade;

		@Override
		public int compareTo(Student o) {
			if(this.grade < o.grade)
				return -1;
			else if(this.grade>o.grade)
				return 1;
			else 
				return 0;
		}
		
		@Deprecated
		public void doASillyThing(){
			System.out.println("I am deprecated");
		}
		
		
	}
	
	static class Teacher implements Comparable<Teacher>{
		int grade;
		public int compareTo(Teacher o) {
			if(this.grade < o.grade)
				return -1;
			else if(this.grade>o.grade)
				return 1;
			else 
				return 0;
		}
	}
	
	
	public static void main(String[] args) {
		
		List l = new ArrayList();
		l.add(new Student());
		l.add(new Teacher());
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student());
		
		//students.add(new Teacher());
		
		List<Comparable> myList = new ArrayList<Comparable>();
		myList.add(new Student());
		myList.add(new Teacher());
		
		
		Student s = new Student();
		s.doASillyThing();
	}
}
