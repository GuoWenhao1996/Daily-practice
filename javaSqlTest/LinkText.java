/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package SqlTest;

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

        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        String sql = null;
        DBHelper help = new DBHelper();
        help.TestConn();

        //��ѯstudent��
        try {
            System.out.println("\n��ѯstudent�������ݣ�");
            dbConn = help.GetConnection();
            dbState = dbConn.createStatement();
            sql = "select * from student";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                System.out.print("ѧ�ţ�" + dbRs.getString("sno"));
                System.out.print("\t������" + dbRs.getString("sname"));
                System.out.print("\t���䣺" + dbRs.getString("sage"));
                System.out.println("\t�Ա�" + dbRs.getString("ssex"));
            }
            dbRs.close();
            dbState.close();
            help.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        //��ѯstulisttb��
        try {
            System.out.println("\n��ѯstulisttb�������ݣ�");
            dbConn = help.GetConnection();
            dbState = dbConn.createStatement();
            sql = "select * from stulisttb";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                System.out.print("ѧ�ţ�" + dbRs.getString(1));
                System.out.print("\t������" + dbRs.getString(2));
                System.out.println("\t״̬��" + dbRs.getString(3));
            }
            dbRs.close();
            dbState.close();
            help.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        //ɾ������
        try {
            System.out.println("\nɾ��stulisttb����ѧ��Ϊ631406010109��ѧ����");
            dbConn = help.GetConnection();
            dbState = dbConn.createStatement();
            String sql2 = "delete stulisttb where id='631406010109'";
            dbState.executeUpdate(sql2);
            sql = "select * from stulisttb";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                System.out.print("ѧ�ţ�" + dbRs.getString(1));
                System.out.print("\t������" + dbRs.getString(2));
                System.out.println("\t״̬��" + dbRs.getString(3));
            }
            dbRs.close();
            dbState.close();
            help.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        //�������
        try {
            System.out.println("\n����ѧ����ѧ�ţ�631406010109"
                    + "  ���������ĺ�"
                    + "  ״̬��11111"
                    + "  ��tulisttb���У�");
            dbConn = help.GetConnection();
            dbState = dbConn.createStatement();
            String sql2 = "insert into stulisttb values('631406010109','���ĺ�',11111)";
            dbState.executeUpdate(sql2);
            sql = "select * from stulisttb";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                System.out.print("ѧ�ţ�" + dbRs.getString(1));
                System.out.print("\t������" + dbRs.getString(2));
                System.out.println("\t״̬��" + dbRs.getString(3));
            }
            dbRs.close();
            dbState.close();
            help.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        //�޸Ĳ���
        try {
            System.out.println("\n�޸�stulisttb����ѧ��Ϊ631406010109��ѧ����״̬Ϊ1");
            dbConn = help.GetConnection();
            dbState = dbConn.createStatement();
            String sql2 = "update stulisttb set state=1 where id='631406010109'";
            dbState.executeUpdate(sql2);
            sql = "select * from stulisttb";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                System.out.print("ѧ�ţ�" + dbRs.getString(1));
                System.out.print("\t������" + dbRs.getString(2));
                System.out.println("\t״̬��" + dbRs.getString(3));
            }
            dbRs.close();
            dbState.close();
            help.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("\n��������������");
    }

}
