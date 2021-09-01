package service;

/**
 * 	@Description 表示员工的状态
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年4月15日下午10:15:05
 *
 */
public class status {
	private final String NAME;
	private status(String name) {
		this.NAME = name ;
	}
	public static final status FREE = new status("FREE");
	public static final status BUSY = new status("BUSY");
	public static final status VOCATION = new status("VOCATION");
	public String getNAME() {
		return NAME;
	}
	@Override
	public String toString() {
		return NAME;
	}
	
	
}
