import java.io.*;
import java.net.*;

public class SummationClient
{
  public static void main(String [] args)
  {
    try
    {
      InetAddress serverHost = InetAddress.getByName(args[0]);
      int serverPort = Integer.parseInt(args[1]);
      int count = Integer.parseInt(args[2]);

      Socket client = new Socket(serverHost,serverPort);
      PrintWriter cout = new PrintWriter(client.getOutputStream());
      cout.println(count);
      //This is essential otherwise TCP keeps buffering data
      cout.flush();

      BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
      System.out.println(br.readLine());
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
