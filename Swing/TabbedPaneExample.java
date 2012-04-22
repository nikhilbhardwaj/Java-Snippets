import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;

public class TabbedPaneExample
{
  private static JScrollPane getTree()
  {
    Properties props = System.getProperties();
    JTree tree = new JTree(props);
    ToolTipManager.sharedInstance().registerComponent(tree);
    TreeCellRenderer renderer = new ToolTipTreeCellRenderer(props);
    tree.setCellRenderer(renderer);
    JScrollPane scrollPane = new JScrollPane(tree);
    return scrollPane;
  }

  private static JScrollPane getTable()
  {
    final Object [][] rowData = {
      {"1","one","un","I"},
      {"2","two","deux","II"},
      {"3","three","trois","III"},
      {"4","four","quatre","IV"},
      {"5","five","cinq","V"},
      {"6","six","trezia","VI"},
      {"7","seven","sept","VII"},
      {"8","eight","huit","VIII"},
      {"9","nine","neur","IX"},
      {"10","ten","dix","X"}
    };

    final Object [] columnNames = {
      "#","English","French","Roman"
    };

    JTable table = new JTable(rowData,columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    return scrollPane;
  }

  public static void main(final String [] args)
  {
    Runnable runner = new Runnable()
    {
      public void run()
      {
        JFrame frame = new JFrame("Tabbed tables, trees and tooltips");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        //add the two tabs
        tabbedPane.addTab("Trees", getTree());
        tabbedPane.addTab("Tables",getTable());

        frame.add(tabbedPane,BorderLayout.CENTER);
        frame.setSize(300,150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}


//Class to render the tooltips for a tree
class ToolTipTreeCellRenderer implements TreeCellRenderer {
  DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
  Dictionary tipTable;

  public ToolTipTreeCellRenderer (Dictionary tipTable) {
    this.tipTable = tipTable;
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value,
      boolean selected, boolean expanded, boolean leaf, int row, boolean
      hasFocus) {
    renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf,
        row, hasFocus);
    if (value != null) {
      Object tipKey;
      if (value instanceof DefaultMutableTreeNode) {
        tipKey = ((DefaultMutableTreeNode)value).getUserObject();
      } else {
        tipKey = tree.convertValueToText(value, selected, expanded, leaf, row,
            hasFocus);
      }
      renderer.setToolTipText((String)tipTable.get(tipKey));
    }
    return renderer;
      }
}

