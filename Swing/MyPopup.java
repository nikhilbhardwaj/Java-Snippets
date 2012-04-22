import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyPopup
{
  private static JLabel statusBar = new JLabel("");
  //The action listener to show which item has been selected
  static class PopupActionListener implements ActionListener
  {
    public void actionPerformed(ActionEvent evt)
    {
      statusBar.setText("Selected: " + evt.getActionCommand());
    }
  }

  //The definition for PopupMenuListener
  static class MyPopupMenuListener implements PopupMenuListener
  {
    public void popupMenuCanceled(PopupMenuEvent pEvt)
    {
      statusBar.setText("Popup Canceled");
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent pEvt)
    {
      statusBar.setText("Popup is Vanishing...");
    }

    public void popupMenuWillBecomeVisible(PopupMenuEvent pEvt)
    {
      statusBar.setText("Becoming Visible...");
    }
  }

  public static void main(final String [] args)
  {
    Runnable runner = new Runnable()
    {
      public void run()
      {
        //The Code for displaying the menu
        JFrame frame = new JFrame("Nikhil's Popup Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener actionListener = new PopupActionListener();
        PopupMenuListener popupMenuListener = new MyPopupMenuListener();

        JPopupMenu popupMenu = new JPopupMenu("Demo");
        popupMenu.addPopupMenuListener(popupMenuListener);

        //New
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(actionListener);
        popupMenu.add(newMenuItem);

        //Open
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(actionListener);
        popupMenu.add(openMenuItem);

        //Separator
        popupMenu.addSeparator();

        //Cut
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(actionListener);
        popupMenu.add(cutMenuItem);

        //Copy
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(actionListener);
        popupMenu.add(copyMenuItem);

        //Paste
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(actionListener);
        pasteMenuItem.setEnabled(false);
        popupMenu.add(pasteMenuItem);

        //Displaying the Menu
        frame.setLayout(new BorderLayout());
        JButton label = new JButton();
        frame.add(label, BorderLayout.CENTER);
        label.setComponentPopupMenu(popupMenu);

        frame.add(statusBar,BorderLayout.SOUTH);
        frame.setSize(350,250);
        frame.setVisible(true);
      }
    };

    EventQueue.invokeLater(runner);
  }
}
