import javax.swing.*;
import java.util.*;
import java.awt.*;

public class CyclicFontsApplet extends JApplet
{
  private java.util.List<Font> fonts;
  private JLabel lbl_rollNo;

  public void init()
  {
    //Let us take the roll no as a parameter from the html code
    lbl_rollNo = new JLabel(getParameter("RollNo"),JLabel.CENTER);
    lbl_rollNo.setSize(400,400);
    fonts = new ArrayList<Font>();
    fonts.add(new Font(Font.MONOSPACED,Font.BOLD,18));
    fonts.add(new Font(Font.SERIF,Font.ITALIC,18));
    fonts.add(new Font("Pristina",Font.BOLD,18));
    //More can be added as per the requirement
    this.setLayout(new BorderLayout());
    this.add(lbl_rollNo,BorderLayout.CENTER);
    this.setVisible(true);
  }

  public void start()
  {
    int i = 0;
    while(true)
    {
      lbl_rollNo.setFont(fonts.get(i));
      i = (i + 1) % fonts.size();
      //Code to sleep for 3 seconds
      try
      {
        Thread.currentThread().sleep(3000);
      }
      catch(InterruptedException iex)
      {
        iex.printStackTrace();
      }
    }
  }
}
