package Blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import utils.JDBCUtil;

/**
 * 
 * 	@Description 使用PreparedStatement操作Blob类型数据
 * 	@author TJ Email:mr.tjvin@foxmail.com
 *	@version
 * 	@date 2021年6月15日下午10:16:05
 *
 */
public class BlobTest {
	//像Customers表插入Blob字段
	@Test
	public void testInsert() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, "jerry");
		ps.setObject(2, "jerry@gmail.com");
		ps.setObject(3, "1996-12-18");
		FileInputStream is = new FileInputStream(new File("1.jfif"));
		ps.setBlob(4,is);
		
		ps.execute();
		JDBCUtil.closeResource(conn, ps);
	}
	//查询customers中Blob类型的字段
	@Test
	public void testQuery(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FileOutputStream fos = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="select photo from customers where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 16);
			rs = ps.executeQuery();
			if(rs.next()) {
				Blob photo = rs.getBlob("photo");
				//将blob类型的字段下载下来，以文件的的形式保存
				InputStream is = photo.getBinaryStream();
				fos = new FileOutputStream("download.jpg");
				byte[] buffer = new byte[1024];
				int len;
				while((len = is.read(buffer)) != -1) {
					fos.write(buffer,0,len);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeResource(conn, ps, rs);
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
