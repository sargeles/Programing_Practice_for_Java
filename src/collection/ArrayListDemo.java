package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Student {
	int id;
	String name;

	public Student(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}

public class ArrayListDemo {
	static ArrayList list = new ArrayList();
	
	public static void main(String[] args) {
		Student student1 =new Student(1, "dopa");
		Student student2 =new Student(2, "faker");
		Student student3 =new Student(3, "sargeles");
		Student[] students = {new Student(4, "rain"),new Student(5, "wind")};
		list.add(student1);
		list.add(student2);
		list.set(1, student3);
		list.addAll(list.size(), Arrays.asList(students));
		
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			Student st=(Student) iter.next();
			System.out.println(list.indexOf(st)+":"+st.toString());
		}
		
	}

}
