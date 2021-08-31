package day1;


import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author TJ
 * @create 2021-06-14  21:39
 */

public class test1 {
    @Test
    public void testConnection1() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();

        //String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
        String url ="jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "MRtjvin12");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }
}
