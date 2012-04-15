import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ConnectSQLite
{
  public static void main(String[] args)
  {
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;

    try
    {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:test_db.db");
      statement = connection.createStatement();
      resultSet = statement
        .executeQuery("SELECT name FROM users");
      while (resultSet.next())
      {
        System.out.println("NAME:"
            + resultSet.getString("name"));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        resultSet.close();
        statement.close();
        connection.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}

