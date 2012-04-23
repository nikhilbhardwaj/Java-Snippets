import java.io.*;
import java.util.StringTokenizer;

public class VigenereCipher
{
  static char [][] cipherKey = new char[26][26];

  public static void main(String [] args) throws IOException
  {
    /* To build the cipher key
       for( char i = 'A'; i <= 'Z'; i++)
       {
       for( int j = 0; j < 26; j++)
       {
       char result = (char)(i + j);
       if ( result > 'Z' ) result -= 26;
       System.out.print(  result + " " );
       }
       System.out.println();
       }
       */
    BufferedReader br = new BufferedReader( new FileReader("CipherKey.txt") );
    String line;
    StringTokenizer strtok;
    for( int i=0;i<26;i++)
    {
      line = br.readLine();
      strtok = new StringTokenizer(line);
      for( int j=0;j<26;j++)
      {
        cipherKey[i][j] = strtok.nextToken().charAt(0);
        //System.out.print(cipherKey[i][j]);
      }
    }
    br.close();
    System.out.println("Vigenere Cipher Demonstration");
    System.out.println("1.Encode Data\n2.Decode Data\nEnter Choice : ");
    br = new BufferedReader(new InputStreamReader(System.in));
    line = br.readLine();
    if(Integer.parseInt(line) == 1)
    {
      encryptText();
    }
    else
    {
      decryptText();
    }
  }

  static void encryptText() throws IOException
  {
    String fileName, keyword, line;
    System.out.println("Enter the file Name to Read");
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    fileName = br.readLine();
    System.out.println("Enter the Keyword");
    keyword = br.readLine();
    keyword = keyword.toUpperCase();
    //to read the file line by line and convert
    BufferedReader fbr = new BufferedReader( new FileReader(fileName) );
    while( (line = fbr.readLine()) != null )
    {
      line = line.toUpperCase();
      for( int i=0;i<line.length();i++)
      {
        char toBeConverted = line.charAt(i);
        char keywordPlace = keyword.charAt( i % keyword.length() );
        if ( toBeConverted - 'A' >=0 && toBeConverted - 'A' <=26 )
        {
          int jIndex = (int) (toBeConverted - 'A');
          int iIndex = (int) (keywordPlace - 'A');
          System.out.print( cipherKey[iIndex][jIndex]);
        }
      }
      System.out.println();
    }
    fbr.close();
  }

  static void decryptText() throws IOException
  {
    String line, fileName, keyword;
    System.out.println("Enter the filename to decode");
    BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    fileName = br.readLine();
    System.out.println("Enter the Keyword");
    keyword = br.readLine();
    keyword = keyword.toUpperCase();
    System.out.println(fileName);
    BufferedReader fbr = new BufferedReader( new FileReader(fileName) );
    while( (line = fbr.readLine()) != null )
    {
      line = line.toUpperCase();
      for( int i=0;i<line.length();i++)
      {
        char toBeConverted = line.charAt(i);
        char keywordPlace = keyword.charAt( i % keyword.length() );
        int decoded = (toBeConverted - keywordPlace);
        decoded = (decoded < 0)? 26 + decoded : decoded;
        System.out.print((char) ( decoded + 'A') );
      }
      System.out.println();
    }
    fbr.close();
  }
}
