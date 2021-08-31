package day1;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.Customer;
import utils.JDBCUtil;
/**
 * 
 * 	@Description 针对不同的表查询多个结果
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年6月15日下午9:25:21
 *
 */
public class PerparedStatementQueryTest2 {
	@Test
	public void testGetInstance() {
		String sql = "select id,name,email,birth from customers where id < ?";
		List<Customer> list = getInstance(Customer.class,sql,12);
		list.forEach(System.out::println);
	}
	public <T> List<T> getInstance(Class<T> clazz,String sql,Object ...args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i = 0 ; i < args.length ; i++) {
				ps.setObject(i + 1, args[i]);
			}
			//执行获取结果集
			rs = ps.executeQuery();
			//获取元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取列数
			int columnCount = rsmd.getColumnCount();
			//创建集合对象
			ArrayList<T> list = new ArrayList<T>();
			while(rs.next()) {
				T t = clazz.getDeclaredConstructor().newInstance();
				for(int i = 0 ; i < columnCount ; i++) {				
					//获取列值通过ResultSet
					Object columnValue = rs.getObject(i+1);
					//获取列名字通过ResultSetMetaData
					//获取列的别名getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i+1);
					//通过反射 进行赋值
					Field field = Customer.class.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, ps, rs);
		}
		return null;
	}
}
