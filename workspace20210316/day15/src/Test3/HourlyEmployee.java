package Test3;

public class HourlyEmployee extends Empolyee {
	private int wage;
	private int hour;
	
	public HourlyEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int earnings() {
		return wage*hour;
	}
	public String toString() {
		return "HourlyEmployee["+super.toString()+"]";
	}
}
