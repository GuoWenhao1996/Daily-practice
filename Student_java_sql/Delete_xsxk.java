
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class Delete_xsxk extends JFrame {

    private JLabel aaa = new JLabel("这里要删除一个学生选课信息，目前尚未开放");

    public Delete_xsxk() {
        super("删除学生选课信息");
        setSize(1200, 500);
        setLocation(130, 120);
        add(aaa);
        setVisible(true);
        myWindowListener();
    }

    private void myWindowListener() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                MainFrame.mf.repaint();
                MainFrame.mf.setVisible(true);
            }
        });
    }
}
