package day1;


import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class Test1 {
	//方式一
	@Test
	public void testConnection1() throws SQLException {
		Driver driver = new com.mysql.cj.jdbc.Driver();
		
		//String url = "jdbc:mysql80://localhost:3306/test";
		String url ="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "MRtjvin12");
		
		Connection conn = driver.connect(url, info);
		
		System.out.println(conn);
	}
	//方式二：
	@Test
	public void testConnection2() throws Exception {
		//1.获取driver实现类的对象，利用反射
		Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
		//2.提供要连接的数据库
		String url ="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
		//3.提供连接需要的用户名和密码
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "MRtjvin12");
		//4.获取连接
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}
	//方式三：使用driverManager替换driver
		@Test
		public void testConnection3() throws Exception {
			//1获取driver实现类的对象
			Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
			Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
			//2提供连接的基本信息
			String url ="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
			String user = "root";
			String password = "MRtjvin12";
			//注册驱动
			DriverManager.registerDriver(driver);
			//获取连接
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.print(conn);
		}
	//方式四：使用driverManager替换driver
			@Test
			public void testConnection4() throws Exception {
				//1提供三个连接的基本信息
				String url ="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
				String user = "root";
				String password = "MRtjvin12";
				//2加载Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
				//注册驱动
				//DriverManager.registerDriver(driver);
				//获取连接
				Connection conn = DriverManager.getConnection(url,user,password);
				System.out.print(conn);
			}
	//方式五：
	@Test
	public void testConnection5() throws Exception {
		//1读取配置文件中的4个基本信息
		InputStream is = Test1.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties pros = new Properties();
		pros.load(is);
		
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverClass = pros.getProperty("driverClass");
		//2.加载驱动	
		Class.forName(driverClass);
		//3.获取连接
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.print(conn);
		
	}
}
