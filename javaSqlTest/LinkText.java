/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guowh
 */
public class LinkText {

    public static void main(String[] args) {

        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        String sql = null;
        DBHelper help = new DBHelper();
        help.TestConn();

        try {
            System.out.println("查询student表中内容：");
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
            help.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            System.out.println("查询stulisttb表中内容：");
            dbConn = help.GetConnection();
            dbState = dbConn.createStatement();
            sql = "select * from stulisttb";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                System.out.print("学号：" + dbRs.getString(1));
                System.out.print("\t姓名：" + dbRs.getString(2));
                System.out.println("\t状态：" + dbRs.getString(3));
            }
            help.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("程序正常结束！");
    }

}
