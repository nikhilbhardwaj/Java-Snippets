import java.net.*;
import java.io.*;

class TCPClientFile
{
	public static void main(String [] args)
	{
		try
		{
			InetAddress ServerAddress = InetAddress.getByName(args[0]);
			int ServerPort = Integer.parseInt(args[1]);
			Socket client = new Socket(ServerAddress,ServerPort);
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			pw.println(args[2]); 	//entering the filename, can enter choco.txt. it's already created
			pw.flush();
			BufferedReader br = new BufferedReader( new InputStreamReader ( client.getInputStream()));	
			System.out.println( br.readLine());	
		}
		catch(UnknownHostException uhe)
		{
			uhe.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}