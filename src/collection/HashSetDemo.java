package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;


public class HashSetDemo {
	static HashSet set = new HashSet();
	
	public static void main(String[] args) {
		Student student1 =new Student(1, "dopa");
		Student student2 =new Student(2, "faker");
		Student student3 =new Student(3, "sargeles");
		Student[] students = {new Student(4, "rain"),new Student(5, "wind")};
		set.add(student1);
		set.add(student2);
		set.add(student3);
		set.addAll(Arrays.asList(students));
		
		Iterator iter = set.iterator();
		while(iter.hasNext())
		{
			Student st=(Student) iter.next();
			System.out.println(st.toString());
		}
		
	}
	
	
	static class Student {
		int id;
		String name;

		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + "]";
		}

	}

}
