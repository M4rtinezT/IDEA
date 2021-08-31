package transaction;

import java.sql.Connection;

import org.junit.Test;

import Utils.JDBCUtil;

public class ConnectionTest {
	@Test
	public void testGetConnection() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		System.out.print(conn);
	}
}
