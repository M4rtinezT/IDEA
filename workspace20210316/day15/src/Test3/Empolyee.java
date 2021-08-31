package Test3;

abstract public class Empolyee {
	private String name;
	private int number;
	private MyDate birthday;
	
	
	
	public Empolyee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}
	public Empolyee() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	public abstract int earnings();
	
	@Override
	public String toString() {
		return "Empolyee [name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString() + "]";
	}
	
	
}
