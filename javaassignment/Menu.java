import javax.swing.*;
import java.awt.event.*;



public class Menu extends JFrame{

	public Menu()
	{
		super("Menu");
		//JMenuBar mb = new JMenuBar();
		//setJMenuBar(mb);
		
		JMenu state1 = new JMenu("State1");
		state1.setMnemonic('A');
		JMenuItem item1 = new JMenuItem("Industries");
		item1.setMnemonic('B');
		JMenuItem item2 = new JMenuItem("Hill Stations");
		JMenuItem item3 = new JMenuItem("Top Institutions");
		
		state1.add(item1);
		state1.add(item2);
		state1.add(item3);
		
		JMenu state2 = new JMenu("State2");
		state2.setMnemonic('C');
		JMenuItem item4 = new JMenuItem("Industries");
		item1.setMnemonic('D');
		JMenuItem item5 = new JMenuItem("Hill Stations");
		JMenuItem item6 = new JMenuItem("Top Institutions");
		state2.add(item4);
		state2.add(item5);
		state2.add(item6);
		
		JMenu state3 = new JMenu("State3");
		state3.setMnemonic('E');
		JMenuItem item7 = new JMenuItem("Industries");
		item1.setMnemonic('F');
		JMenuItem item8 = new JMenuItem("Hill Stations");
		JMenuItem item9 = new JMenuItem("Top Institutions");
		state3.add(item7);
		state3.add(item8);
		state3.add(item9);
		

		
			//adding action listener to menu items
		item1.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Industry : located in ...");
				}
			}
		);
		item2.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Hill Station: located in...");
				}
			}
		);
		item3.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Top Institutes: located in...");
				}
			}
		);	
		item4.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Industry : located in ...");
				}
			}
		);
		item5.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Hill Station: located in...");
				}
			}
		);
		item6.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Top Institutes: located in...");
				}
			}
		);						
		item7.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Industry : located in ...");
				}
			}
		);
		item8.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Hill Station: located in...");
				}
			}
		);
		item9.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Top Institutes: located in...");
				}
			}
		);						

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(state1);
		bar.add(state2);
		bar.add(state3);
		
		getContentPane();
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Menu app = new Menu();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
