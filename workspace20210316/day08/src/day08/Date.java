package day08;

public class Date {
	public static void main(String[] args) {
		MyDate myDate = new MyDate();
		MyDate herDate = new MyDate();
		myDate.assignment(1995,12,4);
		herDate.assignment(1995,7,28);
		myDate.print();
		herDate.print();
	}
}





class MyDate {
	int year,month,day;
	public void assignment(int tureyear,int turemonth,int tureday) {
		year = tureyear;
		month = turemonth;
		day = tureday;		
	}
	public void print() {
		System.out.print("出生日期为："+year+"年"+month+"月"+day+"日");
		System.out.println();
	}
	
}