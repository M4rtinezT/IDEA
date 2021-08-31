package day10;

public class CustomerTest {
	public static void main(String[] args) {
		Customer c1 = new Customer("Janeg", "Smith");
		Account a1 = new Account(1000, 2000, 0.0123);
		c1.setAccount(a1);
		c1.getAccount().deposit(100);
		c1.getAccount().withdraw(960);
		c1.getAccount().withdraw(2000);
		System.out.println(c1.getFirstName()+" "+c1.getLastName()+" has a account: id is "+a1.getId()+",annualInterestRate is "+a1.getAnnualIntersstRate());
	}
}
