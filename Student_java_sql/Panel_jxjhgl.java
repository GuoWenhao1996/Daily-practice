
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
public class Panel_jxjhgl extends JPanel {

//    private JTable table = null;
//    private JScrollPane scrollpane = null;
//    private Vector rowData = new Vector();
//    private Vector columName = new Vector();
//
    protected JPanel p = new JPanel();
//
//    protected Panel_jxjhgl() {
//        Information();
//        BoxLayout horizontal = new BoxLayout(p, BoxLayout.Y_AXIS);
//        p.setLayout(horizontal);
//        p.add(scrollpane);
//    }
//
//    private void Information() {
//        Connection dbConn = null;
//        Statement dbState = null;
//        ResultSet dbRs = null;
//        String sql = null;
//        DBHelper dbhelpr = new DBHelper();
//        columName.add("111");
//        columName.add("222");
//
//        //查询学生信息管理表
//        try {
//            dbConn = dbhelpr.GetConnection();
//            dbState = dbConn.createStatement();
//            sql = "";
//            dbRs = dbState.executeQuery(sql);
//            while (dbRs.next()) {
//                Vector vNext = new Vector();
//                vNext.add(dbRs.getString("xh"));
//                vNext.add(dbRs.getString("xsxm"));
//                rowData.add(vNext);
//            }
//            table = new JTable(rowData, columName);//数据加到表格中
//            dbRs.close();
//            dbState.close();
//            dbhelpr.Close();
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        TableColumn column = null;
//        column = table.getColumnModel().getColumn(0);
//        column.setPreferredWidth(300);
//
//        table.setPreferredScrollableViewportSize(new Dimension(1000, 350));
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
//        scrollpane = new JScrollPane(table);
//    }
}
