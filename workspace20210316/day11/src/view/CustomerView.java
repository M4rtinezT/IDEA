package view;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

/**
 * 
 * 	@Description CustomerView为主模块，负责菜单的显示和处理用户的操作
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月26日下午4:46:38
 *
 */
public class CustomerView {
	private CustomerList customerlist = new CustomerList(10);
	/**
	 * 
	 * 	@Description 显示客户信息管理软件 界面的方法
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午7:07:56
	 */
	public void enterMainMenu() {
		boolean loopFalg = true ;
		while(loopFalg) {
			System.out.println("\n--------------------客户管理软件--------------------");
			System.out.println("                     1.添加客户");
			System.out.println("                     2.修改客户");
			System.out.println("                     3.删除客户");
			System.out.println("                     4.客户列表");
			System.out.println("                     5.退出\n");
			System.out.print("                    请选择(1-5):");
			char menu = CMUtility.readMenuSelection();
			switch(menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("是否确认退出(Y/N):");
				if(CMUtility.readConfirmSelection() == 'Y') {
					loopFalg = false;
				}				
			}
			
		}
	}
	/**
	 * 
	 * 	@Description 添加客户的操作
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午7:06:46
	 */
	private void addNewCustomer() {
		System.out.println("----------------------添加客户--------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		
		System.out.print("电话：");
		String phone = CMUtility.readString(13);
		
		System.out.print("邮箱：");
		String email = CMUtility.readString(20);
		//将上述数据封装到对象中
		Customer customer = new Customer(name, gender, age, phone, email);
		boolean isSucess = customerlist.addCustomer(customer);
		if (isSucess) {
			System.out.println("----------------------添加完成--------------------");
		}else {
			System.out.println("-----------------客户目录已满，添加失败----------------");
		}
	}
	/**
	 * 
	 * 	@Description 修改客户的操作
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午7:06:46
	 */
	private void modifyCustomer() {
		System.out.println("----------------------修改客户--------------------");
		Customer cust;
		int number;
		for (;;) {
			System.out.println("请选择修改客户编号(-1退出):");
			number = CMUtility.readInt();
			if (number == -1) {
				return;
			}
			cust = customerlist.getCustomer(number-1);
			if (cust == null) {
				System.out.println("无法找到指定客户！");	
			}else {
				break;
			}
		}
		System.out.println("姓名("+cust.getName()+"):");
		String name = CMUtility.readString(10, cust.getName());
		System.out.println("性别("+cust.getGender()+"):");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.println("年龄("+cust.getAge()+"):");
		int age = CMUtility.readInt(cust.getAge());
		System.out.println("电话("+cust.getPhone()+"):");
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.println("邮箱("+cust.getEmail()+"):");
		String email = CMUtility.readString(20, cust.getEmail());
		
		Customer newCust = new Customer(name, gender, age, phone, email);
		boolean isRepalaced = customerlist.replaceCustomer(number - 1, newCust);
		if (isRepalaced) {
			System.out.println("----------------------修改完成--------------------");
		}else {
			System.out.println("----------------------修改失败--------------------");
		}
		
	}
	/**
	 * 
	 * 	@Description 删除客户的操作
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午7:06:46
	 */
	private void deleteCustomer() {
		System.out.println("----------------------删除客户--------------------");
		int number;
		for (;;) {	
			System.out.println("请选择删除客户编号(-1退出):");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			Customer customer = customerlist.getCustomer(number-1);
			if (customer == null) {
				System.out.println("无法找到指定客戶！");
			}else {
				break;
			}
		}
		System.out.println("是否确认退出(Y/N):");
		if(CMUtility.readConfirmSelection() == 'Y') {
			customerlist.deleteCustomer(number - 1);
		}
	}
	/**
	 * 
	 * 	@Description 显示客户列表的操作
	 * 	@author TJ 
	 * 	@date 2021年3月26日下午7:06:46
	 */
	private void listAllCustomers() {
		System.out.println("----------------------客户列表--------------------\n");
		int total = CustomerList.getTotal();
		if (total == 0) {
			System.out.println("没有客户记录");
		}else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			Customer[] custs = customerlist.getAllCustomers();
			for (int i = 0 ; i < total ; i++) {
				Customer cust = custs[i];
				System.out.println((i+1)+"\t"+cust.getName()+"\t"+cust.getGender()
				+"\t"+cust.getAge()+"\t"+cust.getPhone()+"\t"+cust.getEmail());
			}
		}
		
		
		System.out.println("---------------------客户列表完成---------------------");
	}
	public static void main(String[] args) {
		CustomerView test = new CustomerView();
		test.enterMainMenu();
	}

}
