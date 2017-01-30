package SQLServerCS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author guowh
 */
public class LinkText {

	public static void main(String[] args) {
		DBHelper help = new DBHelper();
		Connection dbConn = null;
		Statement dbState = null;
		ResultSet dbRs = null;
		String sql = null;

		help.TestConn();

		// 查询student表
		try {
			System.out.println("\n查询student表中内容：");
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			sql = "select * from student";
			dbRs = dbState.executeQuery(sql);
			while (dbRs.next()) {
				System.out.print("学号：" + dbRs.getString("sno"));
				System.out.print("\t姓名：" + dbRs.getString("sname"));
				System.out.print("\t年龄：" + dbRs.getString("sage"));
				System.out.println("\t性别：" + dbRs.getString("ssex"));
			}
			dbRs.close();
			dbState.close();
			help.Close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		// 查询stulisttb表
		try {
			System.out.println("\n查询stulisttb表中内容：");
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			sql = "select * from stulisttb";
			dbRs = dbState.executeQuery(sql);
			while (dbRs.next()) {
				System.out.print("学号：" + dbRs.getString(1));
				System.out.print("\t姓名：" + dbRs.getString(2));
				System.out.println("\t状态：" + dbRs.getString(3));
			}
			dbRs.close();
			dbState.close();
			help.Close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		// 删除测试
		try {
			System.out.println("\n删除stulisttb表中学号为631406010109的学生：");
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			String sql2 = "delete stulisttb where id='631406010109'";
			dbState.executeUpdate(sql2);
			sql = "select * from stulisttb";
			dbRs = dbState.executeQuery(sql);
			while (dbRs.next()) {
				System.out.print("学号：" + dbRs.getString(1));
				System.out.print("\t姓名：" + dbRs.getString(2));
				System.out.println("\t状态：" + dbRs.getString(3));
			}
			dbRs.close();
			dbState.close();
			help.Close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		// 插入测试
		try {
			System.out.println("\n插入学生：学号：631406010109" + "  姓名：郭文浩" + "  状态：11111" + "  到tulisttb表中：");
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			String sql2 = "insert into stulisttb values('631406010109','郭文浩',11111)";
			dbState.executeUpdate(sql2);
			sql = "select * from stulisttb";
			dbRs = dbState.executeQuery(sql);
			while (dbRs.next()) {
				System.out.print("学号：" + dbRs.getString(1));
				System.out.print("\t姓名：" + dbRs.getString(2));
				System.out.println("\t状态：" + dbRs.getString(3));
			}
			dbRs.close();
			dbState.close();
			help.Close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		// 修改测试
		try {
			System.out.println("\n修改stulisttb表中学号为631406010109的学生的状态为1");
			dbConn = help.GetConnection();
			dbState = dbConn.createStatement();
			String sql2 = "update stulisttb set state=1 where id='631406010109'";
			dbState.executeUpdate(sql2);
			sql = "select * from stulisttb";
			dbRs = dbState.executeQuery(sql);
			while (dbRs.next()) {
				System.out.print("学号：" + dbRs.getString(1));
				System.out.print("\t姓名：" + dbRs.getString(2));
				System.out.println("\t状态：" + dbRs.getString(3));
			}
			dbRs.close();
			dbState.close();
			help.Close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		System.out.println("\n程序正常结束！");
	}

}
