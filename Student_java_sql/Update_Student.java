
import java.awt.Font;
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
import javax.swing.JOptionPane;
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
public class Update_Student extends JFrame {

    Panel_xsjcgl p_xsjcgl = new Panel_xsjcgl();
    String XH = "";
    private JLabel lable_xh = new JLabel("学生学号：");
    private JLabel lable_xm = new JLabel("学生姓名：");
    private JLabel lable_xb = new JLabel("学生性别：");
    private JLabel lable_nl = new JLabel("学生年龄：");
    private JLabel lable_csrq = new JLabel("出生日期：");
    private JLabel lable_bj = new JLabel("所在班级：");
    private JLabel lable_mz = new JLabel("学生民族：");
    private JLabel lable_zzmm = new JLabel("政治面貌：");
    private JLabel lable_jl = new JLabel("个人简历：");

    private JLabel lable_bj1 = new JLabel("例：11:计科1班 23:通信3班 32:电子2班 41:物联1班 ");
    private JLabel lable_mz1 = new JLabel("例：01:汉族  02:藏族  03:回族  04:其它");
    private JLabel lable_zzmm1 = new JLabel("例：01:共产党员  02:共青团员  03:群众  04:其它");

    private JTextField textfield_xh = new JTextField(10);
    private JTextField textfield_xm = new JTextField(10);
    private JTextField textfield_xb = new JTextField(10);
    private JTextField textfield_nl = new JTextField(10);
    private JTextField textfield_csrq = new JTextField(10);
    private JTextField textfield_bj = new JTextField(10);
    private JTextField textfield_mz = new JTextField(10);
    private JTextField textfield_zzmm = new JTextField(10);
    private JTextField textfield_jl = new JTextField(10);

    private JButton button_shanchu = new JButton("提交");
    private JButton button_chakan = new JButton("查看");
    private JButton button_guanbi = new JButton("关闭");

    private JPanel p = new JPanel();
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private JPanel p6 = new JPanel();
    private JPanel p7 = new JPanel();
    private JPanel p8 = new JPanel();
    private JPanel p9 = new JPanel();
    private JPanel p10 = new JPanel();
    private JPanel p6_1 = new JPanel();
    private JPanel p7_1 = new JPanel();
    private JPanel p8_1 = new JPanel();

    public Update_Student() {
        super("修改学生基本信息");
        setSize(320, 500);
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        setResizable(false);
        setLocationRelativeTo(null);
        textfield_xm.setText("此处不用填！！！");
        textfield_xb.setText("此处不用填！！！");
        textfield_nl.setText("此处不用填！！！");
        textfield_csrq.setText("此处不用填！！！");
        textfield_bj.setText("此处不用填！！！");
        textfield_mz.setText("此处不用填！！！");
        textfield_zzmm.setText("此处不用填！！！");
        textfield_jl.setText("此处不用填！！！");
        textfield_xm.setEditable(false);
        textfield_xb.setEditable(false);
        textfield_nl.setEditable(false);
        textfield_csrq.setEditable(false);
        textfield_bj.setEditable(false);
        textfield_mz.setEditable(false);
        textfield_zzmm.setEditable(false);
        textfield_jl.setEditable(false);
        button_shanchu.setEnabled(false);
        p.setLayout(horizontal);
        p1.add(lable_xh);
        p1.add(textfield_xh);
        p2.add(lable_xm);
        p2.add(textfield_xm);
        p3.add(lable_xb);
        p3.add(textfield_xb);
        p4.add(lable_nl);
        p4.add(textfield_nl);
        p5.add(lable_csrq);
        p5.add(textfield_csrq);
        p6.add(lable_bj);
        p6.add(textfield_bj);
        p7.add(lable_mz);
        p7.add(textfield_mz);
        p8.add(lable_zzmm);
        p8.add(textfield_zzmm);
        p9.add(lable_jl);
        p9.add(textfield_jl);
        p10.add(button_chakan);
        p10.add(button_shanchu);
        p10.add(button_guanbi);
        p6_1.add(lable_bj1);
        p7_1.add(lable_mz1);
        p8_1.add(lable_zzmm1);
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6_1);
        p.add(p6);
        p.add(p7_1);
        p.add(p7);
        p.add(p8_1);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        add(p);
        setVisible(true);
        myWindowListener();
    }

    private void Look_xs(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        DBHelper dbhelpr = new DBHelper();
        //查看学生
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbState = dbConn.createStatement();
            dbRs = dbState.executeQuery(sql);
            if (dbRs.next()) {
                textfield_xm.setText(dbRs.getString(2));
                textfield_xb.setText(dbRs.getString(3));
                textfield_nl.setText(dbRs.getString(4));
                textfield_csrq.setText(dbRs.getString(5));
                textfield_bj.setText(dbRs.getString(6));
                textfield_mz.setText(dbRs.getString(7));
                textfield_zzmm.setText(dbRs.getString(8));
                textfield_jl.setText(dbRs.getString(9));
                button_shanchu.setEnabled(true);
                textfield_xm.setEditable(true);
                textfield_xb.setEditable(true);
                textfield_nl.setEditable(true);
                textfield_csrq.setEditable(true);
                textfield_bj.setEditable(true);
                textfield_mz.setEditable(true);
                textfield_zzmm.setEditable(true);
                textfield_jl.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(null, "查看失败！\n此学号不存在，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            }
            dbRs.close();
            dbState.close();
            dbhelpr.Close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void Update_xs(String sql) {
        Connection dbConn = null;
        Statement dbState = null;
        DBHelper dbhelpr = new DBHelper();
        //修改学生
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            dbState.executeUpdate(sql);
            dbState.close();
            dbhelpr.Close();
            textfield_xm.setText("此处不用填！！！");
            textfield_xb.setText("此处不用填！！！");
            textfield_nl.setText("此处不用填！！！");
            textfield_csrq.setText("此处不用填！！！");
            textfield_bj.setText("此处不用填！！！");
            textfield_mz.setText("此处不用填！！！");
            textfield_zzmm.setText("此处不用填！！！");
            textfield_jl.setText("此处不用填！！！");
            textfield_xm.setEditable(false);
            textfield_xb.setEditable(false);
            textfield_nl.setEditable(false);
            textfield_csrq.setEditable(false);
            textfield_bj.setEditable(false);
            textfield_mz.setEditable(false);
            textfield_zzmm.setEditable(false);
            textfield_jl.setEditable(false);
            button_shanchu.setEnabled(false);
            JOptionPane.showMessageDialog(null, "修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            if (ex.getMessage().equals("UPDATE 语句与 FOREIGN KEY 约束\"FK_XS_BJTOXS_BJ\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.bj\", column 'bjdm'。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n班级代码有误，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            }else if (ex.getMessage().equals("UPDATE 语句与 FOREIGN KEY 约束\"FK_XS_XSTOMZ_MZ\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.mz\", column 'mzdm'。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n民族代码有误，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            }else if (ex.getMessage().equals("UPDATE 语句与 FOREIGN KEY 约束\"FK_XS_XSTOMZ_MZ\"冲突。该冲突发生于数据库\"Link_DB_Student_631406010109\"，表\"dbo.mz\", column 'mzdm'。")) {
                JOptionPane.showMessageDialog(null, "操作失败！\n民族代码有误，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            }else if (ex.getMessage().equals("将截断字符串或二进制数据。")) {
                JOptionPane.showMessageDialog(null, "    操作失败！\n    班级代码有误，请核对！\n或民族代码有误，请核对！\n或政治面貌代码有误，请核对！", "提示", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "操作失败！\n" + ex.getMessage(), "提示", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void myWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainFrame.mf.setVisible(true);
            }
        });
        //修改事件监听
        button_shanchu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_xh.getText().equals(XH)) {
                    if (textfield_xm.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "姓名不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (!(textfield_xb.getText().toString().equals("男") || textfield_xb.getText().toString().equals("女"))) {
                        JOptionPane.showMessageDialog(null, "性别有误，请输入男/女！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (textfield_nl.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "年龄不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (textfield_csrq.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "出生日期不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (textfield_bj.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "班级不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (textfield_mz.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "民族不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (textfield_zzmm.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "政治面貌不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (textfield_jl.getText().toString().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "简历不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Update_xs("update xs set xsxm='" + textfield_xm.getText()
                                + "',xb='" + textfield_xb.getText()
                                + "',nl='" + textfield_nl.getText()
                                + "',csrq='" + textfield_csrq.getText()
                                + "',bjdm='" + textfield_bj.getText().substring(0,2)
                                + "',mzdm='" + textfield_mz.getText().substring(0,2)
                                + "',zzmmdm='" + textfield_zzmm.getText().substring(0,2)
                                + "',xsjl='" + textfield_jl.getText()
                                + "' where xh='" + XH + "'");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "学号已改变，请重新查询！", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //关闭事件监听
        button_guanbi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainFrame.mf.setVisible(true);
            }
        });
        //查看事件监听
        button_chakan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textfield_xh.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "学号不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
                } else {
                    XH = textfield_xh.getText();
                    Look_xs("select xh,xsxm,xb,nl,csrq,bjmc,mzmc,zzmmmc,xsjl from xs a,mz b,zzmm c,bj d where a.mzdm=b.mzdm and a.zzmmdm=c.zzmmdm and a.bjdm=d.bjdm and xh='" + XH + "'");
                }
            }
        });

    }
}
