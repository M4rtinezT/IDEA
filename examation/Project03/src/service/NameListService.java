package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Equipment;
import domain.NoteBook;
import domain.PC;
import domain.Printer;
import domain.Programmer;

import static service.Data.*;
/**
 * 	@Description 负责讲Data中的数据封装到Employee[]数组中
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年4月16日下午6:14:20
 *
 */
public class NameListService {
	private Employee[] employees;
	/**
	 * 给数组employees及数组元素初始化
	 * 
	 * 
	 */
	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		for(int i = 0 ; i < employees.length; i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name =  EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			switch(type) {
			case EMPLOYEE:		
				employees[i] = new Employee(id,name,age,salary);
				break;
			case PROGRAMMER:
				equipment = creatEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = creatEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = creatEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	/**
	 * 	@Description 获取指定index员工的设备
	 * 	@author TJ 
	 * 	@date 2021年4月16日下午6:36:57
	 *	@param index
	 *	@return
	 */
	private Equipment creatEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		switch(type) {
		case PC://21
			String pcmodel   = EQUIPMENTS[index][1];
			String pcdisplay = EQUIPMENTS[index][2];
			return new PC(pcmodel, pcdisplay);
		case NOTEBOOK://22
			String notebookmodel = EQUIPMENTS[index][1];
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(notebookmodel, price);
		case PRINTER://23
			String printerdisplay = EQUIPMENTS[index][1];
			String printertype    = EQUIPMENTS[index][2];
			return new Printer(printerdisplay, printertype);
		}
		return null;
	}

	/**
	 * 	@Description 获取当前所有的员工
	 * 	@author TJ 
	 * 	@date 2021年4月16日下午7:03:21
	 *	@return
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	
	/**
	 * 	@Description 返回指定ID的员工
	 * 	@author TJ 
	 * 	@date 2021年4月16日下午7:03:46
	 *	@param id
	 *	@return
	 * @throws TeamException 
	 */
	public Employee getEmployees(int id) throws TeamException {
		for (int i = 0 ; i < employees.length ; i++) {
			if(employees[i].getId() == id ) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
	
	
}
