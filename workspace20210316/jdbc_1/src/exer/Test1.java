package exer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import utils.JDBCUtil;

public class Test1 {
	@Test
	public void test1() {
		String sql = "insert into customers(name,email) values(?,?)";
		update(sql,"tom","tom@gmail.com");
	}
	
	public int update(String sql,Object ...args){
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
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.关闭资源
			JDBCUtil.closeResource(conn, ps);		
		}
		return 0;		
	}
}
