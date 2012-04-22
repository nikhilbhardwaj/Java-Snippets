import java.io.*;
import java.net.*;

class SumThread extends Thread
{
  Socket client;
  //Default Constructor
  SumThread(Socket c){ client = c; }

  public void run()
  {
    try
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
      int num_terms = Integer.parseInt(br.readLine());
      int sum = 0;
      //Here we use a slow technique deliberately to illustrate the advantages of the threaded approach
      for(int i=0; i<num_terms; ++i)
      {
        sum += i;
        Thread.currentThread().sleep(1000);
      }
      //Now to write the data back to the client
      PrintWriter cout = new PrintWriter(client.getOutputStream());
      cout.println("The sum you seek is " + sum);
      cout.flush();
      client.close();
    }
    catch(Exception ex)
    {
      System.err.println("Error in the thread");
    }
  }
}

public class SummationServer
{
  public static void main(String [] args)
  {
    try
    {
      //Bind the server to a port chosen at runtime
      ServerSocket server = new ServerSocket(Integer.parseInt(args[0]));
      while(true)
      {
        Socket clientSock = server.accept();
        System.out.println("New client just connected. Spawnig a thread now ...");
        Thread workHorse = new SumThread(clientSock);
        workHorse.start();
      }
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
