package day14;

/**
 * 	@Description  单例模式
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年4月6日下午9:02:12
 *
 */
public class SingletonTest1 {
	public static void main(String[] args) {
		
	}
}



class Singleton1{
	private Singleton1() {
		
	}
//	private static Singleton1() {
//		return new Singleton();
//	}
	private static Singleton1 S1 = new Singleton1();
	public static Singleton1 get() {
		return S1;
	}
	
}