
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
public class Panel_xscjgl extends JPanel {

    protected JPanel p = new JPanel();
    private JButton b = new JButton("这里是学生成绩管理模块！");

    protected Panel_xscjgl() {
        p.add(b);
    }
}
