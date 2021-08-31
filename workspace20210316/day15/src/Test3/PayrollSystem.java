package Test3;

public class PayrollSystem {
	public static void main(String[] args) {
		Empolyee[] emps = new Empolyee[20];
		emps[0] = new SalariedEmployee("Tom", 1002, new MyDate(1995, 12, 4) );
		emps[1] = new HourlyEmployee("sam", 1002, new MyDate(1991, 5, 6));
	}
}
