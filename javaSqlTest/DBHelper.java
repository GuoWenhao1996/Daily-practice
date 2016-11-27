/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package SqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guowh
 */
public class DBHelper {

    Connection dbConn = null;
    String DBName = "test";

    private Connection OpenConn(String sUser, String sPwd) {
        try {
            String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String sDBUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=" + DBName;
            Class.forName(sDriverName);
            dbConn = DriverManager.getConnection(sDBUrl, sUser, sPwd);
            System.out.println("��������������");
        } catch (Exception ex) {
            System.err.println("���ӿ���ʧ�ܣ�");
            System.err.println(ex.getMessage());
        }
        return dbConn;
    }

    protected Connection GetConnection() {
        OpenConn("sa", "123qwe");
        return dbConn;
    }

    protected void TestConn() {
        if (OpenConn("sa", "123qwe") == null) {
            System.err.println("���ݿ�(" + DBName + "):�޷��������ӣ�");
            System.exit(0);
        }
        System.out.println("���ݿ�(" + DBName + ")�����������ӣ�");
        Close();
    }

    protected void Close() {
        try {
            dbConn.close();
            dbConn = null;
            System.out.println("���������رգ�");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
