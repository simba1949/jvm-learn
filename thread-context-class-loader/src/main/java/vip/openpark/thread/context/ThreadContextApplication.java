package vip.openpark.thread.context;

import java.sql.*;

/**
 * @author anthony
 * @since 2024/4/2 23:28
 */
public class ThreadContextApplication {
	public static void main(String[] args) throws SQLException {
		// 1.注册驱动 DriverManger【】
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		// 2.建立连接Connection
		String url = "jdbc:mysql://192.168.5.129:3306/db_learn";
		String user = "root";
		String password = "123456";
		Connection connection = DriverManager.getConnection(url, user, password);
		// 3.获取执行sql语句的对象Statement
		Statement statement = connection.createStatement();
		// 4.执行sql语句
		String sql = "select * from `user`";
		ResultSet resultSet = statement.executeQuery(sql);
		// 5.处理结果
		while (resultSet.next()) {
			// 可以通过指定的字段名获取
			System.out.println("username = " + resultSet.getString("username"));
			// 也可以通过字段顺序获取，其中字段顺序是从1开始
			System.out.println("index[1] = " + resultSet.getString(1));
		}
	}
}