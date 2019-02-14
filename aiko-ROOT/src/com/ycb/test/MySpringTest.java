package com.ycb.test;

import java.sql.*;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringTest {

	@SuppressWarnings("resource") // 该批注的作用是给编译器一条指令，告诉它对被批注的代码元素（ctx）内部的某些警告保持静默。详见另一篇博文：地址
	public static void main(String args[]) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("res/applicationContext.xml"); // 加载spring配置文件

		DataSource dataSource = ctx.getBean("dataSource", DataSource.class);// 加载数据库驱动类

		String sql = "select * from el_bad_details_list"; // 查询表为Student，已在数据库创建

		Connection connection = dataSource.getConnection();

		Statement stm = connection.createStatement();

		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			System.out.println("用户名为:");
			System.out.println(rs.getString(3));
		}
	}

}
