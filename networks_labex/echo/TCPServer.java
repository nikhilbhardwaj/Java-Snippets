import java.net.*;
import java.io.*;

class TCPServer
{
	public static void main(String [] args) 
	{

		try
		{
			int serverPort = Integer.parseInt(args[0]);
			ServerSocket server = new ServerSocket(serverPort);

			while(true)
			{
				Socket client = server.accept();
				System.out.println("New connection established");
				BufferedReader br = new BufferedReader( new InputStreamReader ( client.getInputStream()));
				PrintWriter pw = new PrintWriter(client.getOutputStream());
				pw.println(br.readLine());
				pw.flush();
				client.close();
			}
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