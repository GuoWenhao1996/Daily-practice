
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class Add_xsjc extends JFrame {
    
        Panel_xsjcgl p_xsjcgl = new Panel_xsjcgl();


    private JLabel lable_zhanwei_left = new JLabel("          ");
    private JLabel lable_zhanwei_right = new JLabel("          ");
    private JLabel lable_jlh = new JLabel("奖励编号：");
    private JLabel lable_xh_jl = new JLabel("学生学号：");
    private JLabel lable_jlsj = new JLabel("奖励时间：");
    private JLabel lable_jlnr = new JLabel("奖励内容：");

    private JTextField textfield_jlh = new JTextField(10);
    private JTextField textfield_xh_jl = new JTextField(10);
    private JTextField textfield_jlsj = new JTextField(10);
    private JTextField textfield_jlnr = new JTextField(10);

    private JLabel lable_cfh = new JLabel("                                   惩罚编号：");
    private JLabel lable_xh_cf = new JLabel("                                   学生学号：");
    private JLabel lable_cfsj = new JLabel("                                   惩罚时间：");
    private JLabel lable_cfnr = new JLabel("                                   惩罚内容：");

    private JTextField textfield_cfh = new JTextField(10);
    private JTextField textfield_xh_cf = new JTextField(10);
    private JTextField textfield_cfsj = new JTextField(10);
    private JTextField textfield_cfnr = new JTextField(10);

    private JButton button_tijiao_jl = new JButton("提交");
    private JButton button_qingkong_jl = new JButton("清空");
    private JButton button_guanbi = new JButton("关闭");
    private JButton button_tijiao_cf = new JButton("提交");
    private JButton button_qingkong_cf = new JButton("清空");

    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();

    public Add_xsjc() {
        super("添加学生奖惩信息");
        setSize(600, 300);
        setLocation(430, 290);
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(horizontal);

        textfield_jlh.setEditable(false);
        textfield_cfh.setEditable(false);

        Get_jlh_cfh(textfield_jlh, "select jldm from jlgl");
        Get_jlh_cfh(textfield_cfh, "select cfdm from cfgl");

        p1.add(lable_jlh);
        p1.add(textfield_jlh);
        p1.add(lable_cfh);
        p1.add(textfield_cfh);
        p2.add(lable_xh_jl);
        p2.add(textfield_xh_jl);
        p2.add(lable_xh_cf);
        p2.add(textfield_xh_cf);
        p3.add(lable_jlsj);
        p3.add(textfield_jlsj);
        p3.add(lable_cfsj);
        p3.add(textfield_cfsj);
        p4.add(lable_jlnr);
        p4.add(textfield_jlnr);
        p4.add(lable_cfnr);
        p4.add(textfield_cfnr);
        p5.add(button_tijiao_jl);
        p5.add(button_qingkong_jl);
        p5.add(lable_zhanwei_left);
        p5.add(button_guanbi);
        p5.add(lable_zhanwei_right);
        p5.add(button_tijiao_cf);
        p5.add(button_qingkong_cf);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        add(p);
        setVisible(true);
        myWindowListener();
    }

    private void Get_jlh_cfh(JTextField JT, String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        DBHelper dbhelpr = new DBHelper();
        String NUM = null;
        //查询 奖励管理表 或 惩罚管理表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                NUM = dbRs.getString(1);
            }
            String temp = NUM.substring(0, 2);
            Integer a = Integer.parseInt(NUM.substring(3)) + 1;
            for (int i = 0; i < 8 - a.toString().length(); i++) {
                temp = temp + "0";
            }
            JT.setText(temp + a);
            dbRs.close();
            dbState.close();
            dbhelpr.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void Add_xsjc(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        DBHelper dbhelpr = new DBHelper();
        //插入奖惩
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbState.executeUpdate(sql);
            dbState.close();
            dbhelpr.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void myWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainFrame.mf.repaint();
                MainFrame.mf.setVisible(true);
            }
        });
        //增加事件监听
        button_tijiao_jl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_xsjc("insert into jlgl values('"+textfield_jlh.getText()+"','"+textfield_xh_jl.getText()+"','"+textfield_jlsj.getText()+"','"+textfield_jlnr.getText()+"')");
            }
        });
    }
}
