package exer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.junit.Test;

import utils.JDBCUtil;

public class Test2 {
	//1.向examstudent表中添加一条记录
	@Test
	public void testInsert() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("四级/六级：");
		int type = scanner.nextInt();
		System.out.print("身份证号：");
		String IDCard = scanner.next();
		System.out.print("准考证号：");
		String examCard = scanner.next();
		System.out.print("学生姓名：");
		String studentName= scanner.next();
		System.out.print("所在城市：");
		String location = scanner.next();
		System.out.print("考试成绩：");
		int grade = scanner.nextInt();
		
		String sql = "insert into examstudent(type,IDCard,examcard,studentname,location,grade) values (?,?,?,?,?,?)";
		int insertCount = update(sql,type,IDCard,examCard,studentName,location,grade);
		if(insertCount > 0 ) {
			System.out.print("添加成功");
		}else {
			System.out.print("添加失败");
		}
	}
	
	//通用的增删改操作
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
