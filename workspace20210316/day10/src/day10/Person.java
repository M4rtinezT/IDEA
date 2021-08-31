package day10;

public class Person {
	public static void main(String[] args) {
		PersonTest test = new PersonTest();
		test.setAge(5);
	}
	
}




class PersonTest{
	private int age;
	private String name;
	public void setAge(int a) {
		if(a < 0  || a > 130) {
			System.out.println("数据非法");
		}else {
			age = a ;
		}
	}
	public PersonTest() {
		age = 18 ;
	}
	public PersonTest(String n , int a) {
		age = a ;
		name = n ;
	}
	public int getAge() {
		return age;
	}
	public String name() {
		return name;
	}
}