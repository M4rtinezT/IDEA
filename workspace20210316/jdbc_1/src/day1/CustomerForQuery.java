package day1;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import bean.Customer;
import utils.JDBCUtil;

/**
 * 
 * 	@Description 针对customer表的查询操作
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年6月15日下午5:00:06
 *
 */
public class CustomerForQuery {
	@Test
	public void testQueryCustomers() {
		String sql = "select id,name from customers where name = ?";
		Customer customer = queryForCustomers(sql,"张学友");
		System.out.print(customer);
	}
	//针对customer表的通用查询
	public Customer queryForCustomers(String sql,Object ...args){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			for(int i = 0 ; i < args.length ; i++) {
				ps.setObject(i+1, args[i]);
			}
			rs = ps.executeQuery();
			//获取结果集的元数据 ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();
			//通过ResultSetMetaData获取结果集的列数
			int columnCount = rsmd.getColumnCount();
			if(rs.next()) {
				Customer cust = new Customer();
				for(int i = 0 ; i < columnCount ; i++) {
					Object value = rs.getObject(i+1);
					//获取列名
					String columnName = rsmd.getColumnName(i+1);
					//给cust对象指定的某个属性，赋值为value
					Field field = Customer.class.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(cust, value);
				}
				return cust;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {		
			JDBCUtil.closeResource(conn, ps, rs);
		}
		return null;
	}
	
	@Test
	public void testQuery1(){
		Connection conn = null ;
		PreparedStatement ps = null;
		//执行并返回结果集
		ResultSet resultSet = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select id,name,email,birth from customers where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 3);
			resultSet = ps.executeQuery();
			//处理结果集
			if(resultSet.next()) {//判断结果集下一条是否有数据，返回Boolean类型
				//获取当前这条数据的哥各个字段值
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Date birth = resultSet.getDate(4);
				Customer customer = new Customer(id,name,email,birth);
				System.out.print(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.closeResource(conn, ps, resultSet);
		}
	}

}
