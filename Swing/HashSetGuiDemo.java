import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class HashSetGuiDemo
{
  final static Map<String,String> stateCapitals = new HashMap<String,String>()
  {
    {
      put("TN","Chennai");
      put("Delhi", "New Delhi");
      put("Kerala", "Tiruvananthapuram");
    }
  };
  public static void main(String [] args)
  {
    Runnable runner = new Runnable(){
      public void run()
      {
        JFrame frame = new JFrame("States and Capitals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextField state = new JTextField("Enter the state name here");
        JButton button = new JButton("Find");
        final JLabel searchResults = new JLabel("Click the button");

        ActionListener buttonAction = new ActionListener(){
           public void actionPerformed(ActionEvent evt)
        {
          if(stateCapitals.containsKey(state.getText()))
          searchResults.setText(stateCapitals.get(state.getText()));
          else
            searchResults.setText("State not found");
        }
        };
/*
        button.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent evt)
        {
          searchResults.setText(state.getText());
        }
        });
*/
        button.addActionListener(buttonAction);
        frame.add(state,BorderLayout.NORTH);
        frame.add(button,BorderLayout.WEST);
        frame.add(searchResults,BorderLayout.SOUTH);
        frame.setSize(300,150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
}
