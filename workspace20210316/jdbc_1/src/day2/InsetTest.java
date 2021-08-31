package day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import utils.JDBCUtil;

/** 
 * 	@Description 使用PreparedStatement实现批量数据的操作
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年6月15日下午10:43:03
 */
/*
 * update、delete本身就有批量操作的效果
 * 此时的批量操作主要指的是批量插入
 */
public class InsetTest {
	//方式一
	@Test
	public void testInsert() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			long start = System.currentTimeMillis();
			conn = JDBCUtil.getConnection();
			String sql = "insert into goods(name) values(?)";
			ps = conn.prepareStatement(sql);
			for(int i = 0 ; i < 20000; i++ ) {
				ps.setObject(1, "name_"+ i);
				ps.execute(); 
			}
			long end = System.currentTimeMillis();
			System.out.print("花费的时间为:" + (end - start));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCUtil.closeResource(conn, ps);
		}
	}
	//方式二：
	/*
	 * 1.addBatch();executeBatch(),clearBatch()
	 * mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持
	 * 2.导入jar包
	 */
	@Test
	public void testInsert2() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			long start = System.currentTimeMillis();
			conn = JDBCUtil.getConnection();
			String sql = "insert into goods(name) values(?)";
			ps = conn.prepareStatement(sql);
			for(int i = 0 ; i < 1000000; i++ ) {
				ps.setObject(1, "name_"+ i);
				//1. ‘攒’sql
				ps.addBatch(); 
				if(i % 500 == 0) {
					//2.执行batch
					ps.executeBatch();
					//3.清空batch
					ps.clearBatch();
				}
			}
			long end = System.currentTimeMillis();
			System.out.print("花费的时间为:" + (end - start));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCUtil.closeResource(conn, ps);
		}
	}
	//方式三：
		@Test
		public void testInsert3() {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				long start = System.currentTimeMillis();
				conn = JDBCUtil.getConnection();
				
				//设置不允许自动提交
				conn.setAutoCommit(false);
				
				String sql = "insert into goods(name) values(?)";
				ps = conn.prepareStatement(sql);
				for(int i = 0 ; i < 1000000; i++ ) {
					ps.setObject(1, "name_"+ i);
					//1. ‘攒’sql
					ps.addBatch(); 
					if(i % 500 == 0) {
						//2.执行batch
						ps.executeBatch();
						//3.清空batch
						ps.clearBatch();
					}
				}
				//提交数据
				conn.commit();
				long end = System.currentTimeMillis();
				System.out.print("花费的时间为:" + (end - start));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				JDBCUtil.closeResource(conn, ps);
			}
		}
}
