package Test3;

public class SalariedEmployee extends Empolyee {
	private int monthlySalary;
	
	public SalariedEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
	}
	
	
	
	public int getMonthlySalary() {
		return monthlySalary;
	}



	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}



	public int earnings(){
		return monthlySalary;
	}
	
	public String toString() {
		return "SalariedEmployee["+super.toString()+"]";
	}
}
