
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class Panel_xsxxgl extends JPanel {

    public  JPanel p =null;
    private JButton b = new JButton("这里是学生信息管理模块！");

    public Panel_xsxxgl() {
        p=null;
        p=new JPanel();
        p.add(b);
    }
}
