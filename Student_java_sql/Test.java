
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guowh
 */
public class Test {

    public static void main(String[] args) {

        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        String sql = null;
        DBHelper help = new DBHelper();
        help.TestConn();

        //查询student表
        try {
            System.out.println("\n查询学生信息管理表表中内容：");
            dbConn = help.GetConnection();
            dbState = dbConn.createStatement();
            sql = "select * from 学生信息管理表";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                System.out.print("学号：" + dbRs.getString("学号"));
                System.out.print("\t姓名：" + dbRs.getString("姓名"));
                System.out.print("\t性别：" + dbRs.getString("性别"));
                System.out.println("\t出生日期：" + dbRs.getString("出生日期"));
                System.out.println("\t学生简历：" + dbRs.getString("出生日期"));
                System.out.println("\t ：" + dbRs.getString("出生日期"));
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
