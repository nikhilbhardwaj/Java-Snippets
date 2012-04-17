//2.	Enter your roll no. Display in 3 different fonts for every 3 seconds.

import java.awt.*;
import java.applet.*;
import java.io.*;

/* <applet code = "MyTest" width=200 height=200>
</applet>
*/

public class MyTest extends Applet
{
	String msg = "205110019";
	Font f1,f2,f3;
	//Thread t = null;
	//int state;
	
	public void init()
	{
		//setBackground(Color.cyan);
		//setBackground(Color.red);
		f1 = new Font("Times New Roman", Font.BOLD,12);
		f2 = new Font("Serif",Font.ITALIC,15);
		f3 = new Font("Pristina",Font.BOLD,12);
	}
	
	
	
			
	
	public void paint(Graphics g)
	{
		
		g.setFont(f1);
		g.drawString(msg,100,100);
		try{
		Thread.currentThread().sleep(3000);}
		catch(Exception e){}
		g.setFont(f2);
		g.drawString(msg,200,200);
		try{
		Thread.currentThread().sleep(3000);}
		catch(Exception e){}
		g.setFont(f3);
		g.drawString(msg,300,300);
		try{
		Thread.currentThread().sleep(3000);}
		catch(Exception e){}
		
		repaint();
			
	}
		
}	

		
		