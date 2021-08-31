package service;

/**
 * 	@Description 自定义异常类
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年4月16日下午7:09:28
 *
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -3787516993124229948L;
	public TeamException() {
		super();
	}
	
	public TeamException(String msg) {
		super(msg);
	}
}
