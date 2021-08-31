package day08;

public class Student {
	public static void main(String[] args) {
		StudentInfo[] stus = new StudentInfo[20];
		for (int i = 0 ; i < 20 ; i++) {
			stus[i] = new StudentInfo();
			stus[i].number=i+1;
			stus[i].state=(int)(Math.random()*6+1);
			stus[i].score=(int)(Math.random()*101);		
		}
		// 冒泡排序成绩
//		StudentInfo temp;
//		for (int i = 0 ; i < stus.length - 1; i++) {
//			for (int j = 0 ; j < stus.length - 1 - i ; j++) {
//				if(stus[j].score > stus[j+1].score) {
//					temp = stus[j];
//					stus[j] = stus[j+1];
//					stus[j+1] = temp ;
//				}
//			}
//		}
		
		//输出年级为3的
//		for (int i = 0 ; i < 20 ; i++) {
//			if(stus[i].state == 3) {
//				System.out.print("学号是："+stus[i].number+" "+"年级是："+stus[i].state+" "+"成绩是:"+stus[i].score+"\n");
//			}
//		}
		
		//遍历
//		for (int i = 0 ; i < stus.length ; i++) {
//			stus[i].info();
//			
//		}
		StudentInfo test = new StudentInfo();
		test.bubble(stus);
		test.searchState(stus, 3);
		test.print(stus);
		
	}
}







class StudentInfo{
	int number,state,score;
	/**
	 * 
	 * 	@Description 输出一组数据
	 * 	@author TJ 
	 * 	@date 2021年3月22日下午9:33:33
	 */
	public void info() {
		System.out.print("学号："+number+" 年级："+state+" 成绩："+score); 
		System.out.println();
	}
	/**
	 * 
	 * 	@Description 遍历
	 * 	@author TJ 
	 * 	@date 2021年3月22日下午9:33:51
	 *	@param stus 指定数据
	 */
	public void print(StudentInfo[] stus) {
		for (int i = 0 ; i < stus.length ; i++) {
			stus[i].info();
		}
	}
	
	/**
	 * 
	 * 	@Description 排序
	 * 	@author TJ 
	 * 	@date 2021年3月22日下午9:34:01
	 *	@param stus  数据排序
	 */
	public void bubble(StudentInfo[] stus) {
		StudentInfo temp;
		for (int i = 0 ; i < stus.length - 1; i++) {
			for (int j = 0 ; j < stus.length - 1 - i ; j++) {
				if(stus[j].score > stus[j+1].score) {
					temp = stus[j];
					stus[j] = stus[j+1];
					stus[j+1] = temp ;
				}
			}
		}
	}
	
	
	/**
	 * 
	 * 	@Description   输出指定年级
	 * 	@author TJ 
	 * 	@date 2021年3月22日下午9:34:07
	 *	@param stus   数据
	 *	@param stateInfo  指定年级
	 */
	public void searchState(StudentInfo[] stus,int stateInfo) {
		for (int i = 0 ; i < stus.length ; i++) {
			if(stus[i].state == stateInfo) {
				System.out.print("学号是："+stus[i].number+" "+"年级是："+stus[i].state+" "+"成绩是:"+stus[i].score+"\n");
			}
		}
	}
}