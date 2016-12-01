
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class MainFrame extends JFrame {
    private JButton button_xsxxgl = new JButton("学生信息管理模块");
    private JButton button_kcgl = new JButton("课程管理模块");
    private JButton button_jxjhgl = new JButton("教学计划管理模块");
    private JButton button_xsxkgl = new JButton("学生选课管理模块");
    private JButton button_xscjgl = new JButton("学生成绩管理模块");
    private JButton button_xsjcgl = new JButton("学生奖惩管理模块");

    FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
    private JPanel panel_choose = new JPanel(flow);
    private JPanel panel_info = new JPanel();

    Panel_xsxxgl p_xsxxgl = new Panel_xsxxgl();
    Panel_kcgl p_kcgl = new Panel_kcgl();

    public MainFrame() {
        super("学生信息查询系统");
        setSize(1100, 600);
        setLocation(170, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_choose.add(button_xsxxgl);
        panel_choose.add(button_kcgl);
        panel_choose.add(button_jxjhgl);
        panel_choose.add(button_xsxkgl);
        panel_choose.add(button_xscjgl);
        panel_choose.add(button_xsjcgl);
        GridLayout gird = new GridLayout(2, 1);
        this.setLayout(gird);
        add(panel_choose);
        add(panel_info);
        myEventListener();
        setVisible(true);
    }

    private void myEventListener() {
        //全部开始事件监听
        button_xsxxgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_xsxxgl.setEnabled(false);
                button_kcgl.setEnabled(true);
                p_kcgl.p.setVisible(false);
                p_xsxxgl = new Panel_xsxxgl();
                panel_info.add(p_xsxxgl.p);
                setVisible(true);
            }
        });
        button_kcgl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button_kcgl.setEnabled(false);
                button_xsxxgl.setEnabled(true);
                p_xsxxgl.p.setVisible(false);
                p_kcgl = new Panel_kcgl();
                panel_info.add(p_kcgl.p);
                setVisible(true);
            }
        });
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] args) {
        setLookAndFeel();
        MainFrame mf = new MainFrame();
    }
}
