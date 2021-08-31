package day12;

public class Student extends Person{
	long numer;
	int math;
	int english;
	int computer;
	public Student(String name, char sex, int age, long numer, int math, int english, int computer) {
		super(name, sex, age);
		this.numer = numer;
		this.math = math;
		this.english = english;
		this.computer = computer;
	}
	
	
	
}
