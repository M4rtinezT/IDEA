package Account;

public class Account {
	private double balance;
	public Account(double init_balance) {
		this.balance = init_balance;
	}
	public double getBalance() {
		return balance;
	}
	//存钱
	public void deposit(double amount) {
		if (amount > 0) {
			balance+=amount;
			System.out.println("存钱成功");
		}
	}
	
	//取钱
	public void withdraw(double amount) {//取钱
		if(this.balance < amount) {
			System.out.println("余额不足，取款失败！");
		}else {
			this.balance -=amount;
			System.out.println("成功取出："+amount);
		}
	}
}
