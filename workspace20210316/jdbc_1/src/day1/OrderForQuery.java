package day1;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import utils.JDBCUtil;

/**
 * 
 * 	@Description
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年6月15日下午7:07:38
 *
 */
public class OrderForQuery {
	@Test
	public void testOrderForQuery() {
		//String sql ="select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		String sql ="select order_id,order_name,order_date from `order` where order_id = ?";
		Order order = orderForQuery(sql,1);
		System.out.print(order);
	}
	
	
	/**
	 * 
	 * 	@Description 通用的针对于order表的查询操作
	 * 	@author TJ 
	 * 	@date 2021年6月15日下午8:28:37
	 *	@return
	 * @throws Exception 
	 */
	public Order orderForQuery(String sql,Object ...args){
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
			if(rs.next()) {
				Order order = new Order();
				for(int i = 0 ; i < columnCount ; i++) {				
					//获取列值通过ResultSet
					Object columnValue = rs.getObject(i+1);
					//获取列名字通过ResultSetMetaData
					//获取列的别名getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i+1);
					//通过反射 进行赋值
					Field field = Order.class.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(order, columnValue);
				}
				return order;
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
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				int id = (int) rs.getObject(1);
				String name = (String) rs.getObject(2);
				Date date = (Date) rs.getObject(3);
				Order order = new Order(id,name,date);
				System.out.print(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCUtil.closeResource(conn, ps, rs);
		}
	}
}
class Order{
	private int orderId;
	private String orderName;
	private Date orderDate;
	public Order() {
		super();
	}
	public Order(int orderId, String orderName, Date orderDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderDate = orderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderDate=" + orderDate + "]";
	}
	
}