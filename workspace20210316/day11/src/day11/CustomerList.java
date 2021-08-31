package day11;

import bean.Customer;

public class CustomerList {
	//声明Customer类型数组customers和记录存储的客户的个数的变量
	private Customer[] customers;
	private static int total = 0; //用户个数
	// 构造器 用来初始化customers数组
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/**添加指定客户到数组中
	 * @return 添加是否成功
	 * 
	 */
	public boolean addCustomer(Customer customer) {
		if (total < customers.length) {
			customers [total++] = customer; //total等于数组的长度
			return true;
		}
		return false;
	}
	/**
	 * 替换指定索引位置上的数组元素
	 * @return 是否替换成功
	 * index 是数组的索引位置
	 */
	public boolean replaceCustomer(int index,Customer cust) {
		if(index > 0 && index < total) {
			customers[index] = cust;
			return true;
		}
		return false;
	}
	/**删除指定索引位置上的元素
	 * @ return 是否成功
	 * 
	 */
	public boolean deleteCustomer(int index) {
		if(index > 0 && index < total) {
			for (int i = index  ;i < total -1 ; i++) {
				customers[i] = customers[i + 1];
			}
			customers[total--] = null ;
			return true;
		}
		return false;
	}
	/**
	 * 获取所有的customers对象构成的数组
	 */
	public Customer[] getAllCustomers() {
		Customer [] custs = new Customer[total];
		for (int i = 0 ; i < total ; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	/**
	 * 返回指定索引位置上的Customer
	 * @return 如果输入的index位置上的元素不存在 返回null
	 */
	public Customer getCustomer(int index) {
		if(index > 0 && index < total) {
			return customers[index];
		}
		return null;
	}
	/**
	 * 返回Customer对象的个数
	 */
	public static int getTotal() {
		return total;
	}
}
