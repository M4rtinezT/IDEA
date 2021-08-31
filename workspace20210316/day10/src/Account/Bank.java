package Account;

public class Bank {
	private Customer[] customers = new Customer[60];//存放多个客户的数据
	private int numberOfCustomer;//客户的长度
	public Bank() {
		
	}
	//添加客户
	public void addCustomer(String f,String l) {
		Customer cust = new Customer(f,l);
		customers[numberOfCustomer++] = cust;
	}
	
	//获取客户的个数
	public int getNumOfCustomer() {
		return numberOfCustomer;
		
	}
	
	//获取指定位置上的客户
	public Customer getCustomer(int index) {
		if(index>=0 && index <numberOfCustomer) {
			return customers[index];
		}
		else {
			return null;
		}
	}
	
}
