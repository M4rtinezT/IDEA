package day14;

public class AccountTest {
	public static void main(String[] args) {
		Account acct1 = new Account();
		Account acct2 = new Account("147258",20000);
		Account acct3 = new Account("123456", 1000);
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
	}
}



class Account{
	private int id;
	private String passcode = "000000";
	private double balance ;
	
	private static double interestRate;
	private static double minueBalance = 1.0;	
	private static int init = 1001;//自动生成ID
	
	public Account() {
		id = init++;
	}
	public Account(String passcode,double balance) {
		this();
		this.passcode = passcode;
		this.balance = balance;
	}
	
	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public static double getInterestRate() {
		return interestRate;
	}

	public static void setInterestRate(double interestRate) {
		Account.interestRate = interestRate;
	}

	public static double getMinueBalance() {
		return minueBalance;
	}

	public static void setMinueBalance(double minueBalance) {
		Account.minueBalance = minueBalance;
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", passcode=" + passcode + ", balance=" + balance + "]";
	}
	
	
}