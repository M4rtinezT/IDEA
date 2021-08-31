package day13;

public class MyDateTest {

}



class MyDate{
	private int day;
	private int month;
	private int year;
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj ) {
//			return true;
//		}
//		if (obj instanceof MyDate) {
//			MyDate temp = (MyDate)obj;
//			return temp.getDay() == this.getDay() && 
//					temp.getMonth() == this.getMonth() &&
//					temp.getYear() == this.getYear();
//		}
//		return false;
//	}
	
}