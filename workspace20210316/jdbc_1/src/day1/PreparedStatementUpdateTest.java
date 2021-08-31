package day1;
/*
 * 使用PreparedStatement替换statement，实现对数据表的增删改操作
 * 
 * 增删改
 * 
 * 
 * 
 */

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;


import org.junit.Test;

import utils.JDBCUtil;

public class PreparedStatementUpdateTest {
	@Test
	public void testCommonUpdate() {
		String sql = "delete from customers where id = ?";
		update(sql,1);
	}
	
	//通用的增删改操作
	@Test
	public void update(String sql,Object ...args){//args和可变形参的个数一致
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取数据库连接
			conn = JDBCUtil.getConnection();
			//2.预编译SQL语句，返回PreperdStatement实例
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			for(int i = 0 ; i < args.length ; i++) {
				ps.setObject(i+1, args[i]);
			}
			//4.执行
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.关闭资源
			JDBCUtil.closeResource(conn, ps);		
		}
		
	}
	//向customers表修改一条记录
	@Test
	public void testUpdate(){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1.获取数据库连接
			conn = JDBCUtil.getConnection();
			//2.预编译SQL语句，返回PreperdStatement实例
			String sql = "update customers set name = ? where id = ?";
			ps = conn.prepareStatement(sql);
			//3.填充占位符
			ps.setObject(1, "莫扎特");
			ps.setObject(2, 18);
			//4.执行
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5.资源的关闭
			JDBCUtil.closeResource(conn, ps);
			
		}
	}
	
	
	
	//向customers表添加一条记录
	@Test
	public void testInsert(){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//1读取配置文件中的4个基本信息
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
			
			Properties pros = new Properties();
			pros.load(is);
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String url = pros.getProperty("url");
			String driverClass = pros.getProperty("driverClass");
			//2.加载驱动	
			Class.forName(driverClass);
			//3.获取连接
			conn = DriverManager.getConnection(url,user,password);
			//4.预编译SQL语句，返回PreparedStatement实例
			String sql = "insert into customers(name,email,birth)values(?,?,?)";//?占位符
			ps = conn.prepareStatement(sql);
			//5.填充占位符
			ps.setString(1, "哪吒");
			ps.setString(2, "nezha@gmail.com");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse("1000-11-25");
			ps.setDate(3, new Date(date.getTime()));
			//6.执行SQL
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.资源的关闭
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
