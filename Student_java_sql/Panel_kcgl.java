
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guowh
 */
public class Panel_kcgl extends JPanel {

    private JTable table = null;
    private JScrollPane scrollpane = null;
    private Vector rowData = new Vector();
    private Vector columName = new Vector();

    protected JPanel p = new JPanel();

    protected Panel_kcgl() {
        Information();
        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(horizontal);
        p.add(scrollpane);
    }

    private void Information() {
        Connection dbConn = null;
        Statement dbState = null;
        ResultSet dbRs = null;
        String sql = null;
        DBHelper dbhelpr = new DBHelper();
        columName.add("课程代码");
        columName.add("课程名称");
        columName.add("学分");
        columName.add("开课学院");
        //查询学生信息管理表
        try {
            dbConn = dbhelpr.GetConnection();
            dbState = dbConn.createStatement();
            sql = "select xymc,kcdm,kcmc,xf from kc a,xy b where a.xydm=b.xydm";
            dbRs = dbState.executeQuery(sql);
            while (dbRs.next()) {
                Vector vNext = new Vector();
                vNext.add(dbRs.getString("xymc"));
                vNext.add(dbRs.getString("kcdm"));
                vNext.add(dbRs.getString("kcmc"));
                vNext.add(dbRs.getString("xf"));
                rowData.add(vNext);
            }
            table = new JTable(rowData, columName);//数据加到表格中
            dbRs.close();
            dbState.close();
            dbhelpr.Close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        TableColumn column = null;
        column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);        column = table.getColumnModel().getColumn(2);
        column.setPreferredWidth(200);

        table.setPreferredScrollableViewportSize(new Dimension(700, 350));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        scrollpane = new JScrollPane(table);
    }
}
