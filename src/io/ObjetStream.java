package io;

import java.io.*;

public class ObjetStream {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectOutputStream objectwriter = null;
		ObjectInputStream objectreader = null;

		try {
			objectwriter = new ObjectOutputStream(new FileOutputStream(
					"C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile1.txt"));
			objectwriter.writeObject(new Student("gg", 22));
			objectwriter.writeObject(new Student("tt", 18));
			objectwriter.writeObject(new Student("rr", 17));
			objectreader = new ObjectInputStream(new FileInputStream(
					"C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile1.txt"));
			for (int i = 0; i < 3; i++) {
				System.out.println(objectreader.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				objectreader.close();
				objectwriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}

class Student implements Serializable {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}