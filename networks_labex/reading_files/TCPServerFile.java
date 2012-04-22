import java.net.*;
import java.io.*;

class TCPServerFile
{
	public static void main(String [] args) 
	{
		try
		{
			int serverPort = Integer.parseInt(args[0]);
			ServerSocket server = new ServerSocket(serverPort);
			int i;
			String clientFile;
		
			while(true)
			{
				Socket client = server.accept();
				System.out.println("New connection established");
				BufferedReader br = new BufferedReader( new InputStreamReader( client.getInputStream()));
				PrintWriter pw =new PrintWriter(client.getOutputStream());
				clientFile = br.readLine();								//getting file name from client
				FileInputStream fin;
				try 
				{
					fin = new FileInputStream(clientFile);
				}
				catch(FileNotFoundException e) 
				{
					pw.println("Source File Not Found\n");
					return;
				}
				
				//code to read the number of alphabets, numbers, special characters
				int alpha=0,num=0,spl_c=0;
				do
				{
					i=fin.read();
					if(i!=-1)
					{
						if((i>=65 && i<=90) || (i>=97&& i<=122))
							alpha++;
						else if(i>=47 && i<=57)
							num++;
						else
							spl_c++;
					}
				}while (i!=-1);
				fin.close();
				pw.println("Albhabets : "+ alpha +" Digits : "+ num + " Special Characters : "+ spl_c +'\n');
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

			