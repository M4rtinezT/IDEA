package service;

import bean.Customer;

/**
 * 
 * 	@Description CustomerList为Customer对象的管理模块
 * 	内部用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法
 *  供CustomerView调用
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月26日下午4:41:59
 *
 */
public class CustomerList {
	private Customer[] customers;//保存客户对象的数组
	private static int total = 0 ;      //记录已保存的客户对象的数量
	/**
	 * 用来初始化customer数组的构造器
	 * @param totalCustomer：指定数组的长度
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/**
	 * 
	 * 	@Description 将指定的客户添加到数组中
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午6:41:00
	 *	@param customer
	 *	@return 添加成功返回true 添加失败返回false
	 */
	public boolean addCustomer(Customer customer) {
		if (total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	/**
	 * 
	 * 	@Description 修改指定索引位置的客户信息
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午6:43:12
	 *	@param index
	 *	@param cust
	 *	@return 修改成功返回true 修改失败返回false
	 */
	public boolean replaceCustomer(int index,Customer cust) {
		if (index > total && index < 0) {
			return false;
		}
		customers[index] = cust;
		return true;
	}
	/**
	 * 
	 * 	@Description 删除指定索引位置的客户信息
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午6:45:59
	 *	@param index
	 *	@return 删除成功返回true 删除失败返回false
	 */
	public boolean deleteCustomer(int index) {
		if (index < 0 && index >= total) {
			return false;
		}
		for (int i = index ; i < total - 1 ; i++) {
			customers[i] = customers [i+1];
		}
		customers[--total] = null;
		return true;
	}
	/**
	 * 
	 * 	@Description 获取所有客户的信息
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午6:49:12
	 *	@return 
	 */ 
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for (int i = 0 ; i < total ; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	/**
	 * 
	 * 	@Description 获取指定索引位置上的客户
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午6:49:15
	 *	@param index
	 *	@return 如果找到了元素，则返回，如果没有找到，返回null
	 */
	public Customer getCustomer(int index) {
		if (index <= 0 && index > total) {
			return null;
		}
		return customers[index];
	}
	/**
	 * 
	 * 	@Description 获取存储的客户的数量
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午6:59:04
	 *	@return
	 */
	public static int getTotal() {
		return total;
	}
}
