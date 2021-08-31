package day08;

public class Person {
	String name;
	int age;
	/**
	 * 
	 * 1是男性 0是女性
	 * 
	 * 
	 */
	int sex;
	public void study() {
		System.out.println("studying");
	}
	public void showAge() {
		System.out.println("age:"+age);
	}
	public int addAge(int i) {
		age+=i;
		return age;
	}
}
