import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Menu extends JFrame{
  private static Map<String,String> stateDetails;
  //to initialize the map
  public static void initializeStateDetails()
  {
    stateDetails = new HashMap<String,String>();
    stateDetails.put("Tamil Nadu,Industries", "Salem is the most famous industrial town in TN");
    stateDetails.put("Tamil Nadu,Hill Stations", "Kodaikanal and Ooty are the hill stations to visit here");
	stateDetails.put("Tamil Nadu,Top Institutions","Two major ones are NITT and IIT");
	stateDetails.put("West Bengal,Industries","Durgapur is a major industrial town");
	stateDetails.put("West Bengal,Hill Stations","Darjeeling ,a famous hill station is situated here");
	stateDetails.put("West Bengal,Top Institutions", "IIT Kharagpur,Presidency College are few of the major ones");
	stateDetails.put("Haryana,Industries", "Gurgaon a growing hub for industries is part of this state");
	stateDetails.put("Haryana,Hill Stations", "Morni Hills, the only hill station of Haryana");
	stateDetails.put("Haryana,Top Institutions","NIT Kurukshetra, a very famous institute");
	
    //add more state details here similarly
  }

  public JMenuItem cloneMenuItem(JMenuItem item)
  {
    //Hackish method to behave like Object.clone()
    JMenuItem newItem = new JMenuItem(item.getText());
    newItem.setMnemonic(item.getMnemonic());
    return newItem;
  }

  private JLabel stateTrivia;
  private JMenu [] states;
  private JMenuItem [] items;
  private List<JMenuItem> allItems;

  public Menu()
  {
    super("Funky Menu");

    states = new JMenu [3];
    items = new JMenuItem [3];
    allItems = new ArrayList<JMenuItem>();
    //Initializing the items
    items[0] = new JMenuItem("Industries");
    items[0].setMnemonic('I');
    items[1] = new JMenuItem("Hill Stations");
    items[1].setMnemonic('H');
    items[2] = new JMenuItem("Top Institutions");
    items[2].setMnemonic('T');

    //Initializing the states
    //I've set the adjacent keys as the Mnemonics for easy user interaction
    //though it is less intuitive, it can vary on the user preference.
    states[0] =  new JMenu("Tamil Nadu"); states[0].setMnemonic('Q');
    states[1] = new JMenu("West Bengal"); states[1].setMnemonic('W');
    states[2] = new JMenu("Haryana"); states[2].setMnemonic('E');

    //Adding all the items to each of the states
    for(int i=0; i<3; ++i)
    {
      for(int j=0; j<3; ++j)
      {
        JMenuItem tmp = cloneMenuItem(items[j]);
        allItems.add(tmp);
        states[i].add(tmp);
      }
    }

    //adding action listener to menu items
    for(int j=0; j<allItems.size(); ++j)
    {
      allItems.get(j).addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt)
      {
        //Slightly tricky code, had to look at stackoverflow to figure this out
        JMenuItem currentItem = (JMenuItem) evt.getSource();
        JPopupMenu parentOfItem = (JPopupMenu) currentItem.getParent();
        JMenu invoker = (JMenu)parentOfItem.getInvoker();
        final String textToDisplay = invoker.getText() + "," + currentItem.getText();
        System.out.println(stateDetails.get(textToDisplay));
        stateTrivia.setText(stateDetails.get(textToDisplay));
      }
      });
    }
    //finally to fix up the MenuBar
    JMenuBar bar = new JMenuBar();
    setJMenuBar(bar);
    for(int i=0; i<3; ++i)
    {
      bar.add(states[i]);
    }

    getContentPane();
    //Update contents on the screen using a label
    stateTrivia = new JLabel("Choose any Menu Item to know about the details of the state",JLabel.CENTER);
    stateTrivia.setSize(400,400);
    add(stateTrivia);
    setSize(500, 500);
    setVisible(true);
  }

  public static void main(String [] args)
  {
    initializeStateDetails();
    Menu app = new Menu();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
