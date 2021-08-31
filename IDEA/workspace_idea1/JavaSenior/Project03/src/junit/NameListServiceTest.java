package junit;

import org.junit.Test;

import domain.Employee;
import service.NameListService;
import service.TeamException;

/**
 * 	@Description NameListService测试
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年4月16日下午7:15:23
 *
 */
public class NameListServiceTest {
	
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0 ; i < employees.length ; i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void tesGetEmployee() {
		NameListService service = new NameListService();
		int id = 13 ;
		try {
			Employee employee = service.getEmployees(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
