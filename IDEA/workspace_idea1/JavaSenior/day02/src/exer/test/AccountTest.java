package exer.test;

/**
 * 银行有一个账户
 * 有两个储户分别像同一个账户存3000，每次存1000，分三次，每次存完打印余额
 * @author TJ
 * @create 2021-04-24  22:07
 */
public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account(0.0);
        Customer c1 = new Customer(a1);
        Customer c2 = new Customer(a1);
        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}


class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double amt){
        if(amt > 0){
            balance += amt;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":存款成功，余额为："+ balance);
        }
    }
}

class Customer extends Thread{
    private final Account acct;
    public Customer(Account acct){
        this.acct = acct;
    }
    @Override
    public void run() {
        for(int i = 0 ; i < 3 ; i++){
            acct.deposit(1000);
        }

    }
}