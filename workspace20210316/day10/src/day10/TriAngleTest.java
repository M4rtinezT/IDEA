package day10;

/**
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月25日下午6:22:11
 *
 */
public class TriAngleTest {
	public static void main(String[] args) {
		TriAngle t1 = new TriAngle();
		t1.setBase(2.2);
		System.out.println(t1.getBase());
	}
}

/**
 * 
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年3月25日下午6:22:21
 *
 */

class TriAngle{
	private double base; // 底边长
	private double height;  //高
	
	
	public TriAngle() {
		
	}
	public TriAngle(double b , double h) {
		base = b ;
		height = h ;
	}
	
	public void setBase(double b) {
		base = b ;
	}
	public double getBase() {
		return base;
	}
	public void setHeight(double h) {
		height = h ;
	}
	public double getHeight() {
		return height;
	}
}