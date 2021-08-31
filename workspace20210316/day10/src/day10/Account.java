package day10;

class Account {
	private int id;  //账号
	private double balance;  //余额
	private double annualIntersstRate;  //利率
	//构造器
	public Account(){
		
	}

	
	public Account(int id, double balance, double annualIntersstRate) {
		this.id = id;
		this.balance = balance;
		this.annualIntersstRate = annualIntersstRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualIntersstRate() {
		return annualIntersstRate;
	}

	public void setAnnualIntersstRate(double annualIntersstRate) {
		this.annualIntersstRate = annualIntersstRate;
	}
	
	public void withdraw(double amount) {//取钱
		if(this.balance < amount) {
			System.out.println("余额不足，取款失败！");
		}else {
			this.balance -=amount;
			System.out.println("成功取出："+amount);
		}
	}
	public void deposit(double amount) {//存钱
		if(amount > 0) {
			this.balance +=amount;
			System.out.println("成功存入："+amount);
		}
	}
}
