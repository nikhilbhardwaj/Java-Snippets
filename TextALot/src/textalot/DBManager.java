package textalot;

import java.sql.*;
import java.util.*;
import javax.swing.JTable;

/**
 *
 * @author Nikhil
 */
public class DBManager {
    
    static Connection connection = null;
    static ResultSet resultSet = null;
    static Statement statement = null;
    
    static
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            //Initial setup for the connection and the statement
            connection = DriverManager.getConnection("jdbc:sqlite:phonebook.db");
            statement = connection.createStatement();
        }
        catch(Exception ex)
        {
            System.err.println("Database Connectivity Issues!!");
        }
    }
   
    public static List getContacts(JTable contactsTable)
    {
        List<Contact> contacts = new ArrayList<>();
        try
        {
            Contact tmpContact;
            resultSet = statement.executeQuery("SELECT * FROM contacts order by name");
            while (resultSet.next())
            {
                tmpContact = new Contact(Integer.parseInt(resultSet.getString("cid")),resultSet.getString("name"),resultSet.getString("phone"));
                contacts.add(tmpContact);
                //System.out.println("Contact : " + tmpContact);
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
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        Object [][] tableRows = new Object[contacts.size()][];
        for(int i=0; i<contacts.size(); ++i)
        {
            tableRows[i] = new Object[]{contacts.get(i)};
        }
        contactsTable.setModel(new javax.swing.table.DefaultTableModel(tableRows, new String [] {"Name"})
        {
            @Override
            public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
            }
        });
        
        return contacts;
  }
    
    public static void addContact(String name, String phone)
    {
        try
        {
            statement.executeUpdate("insert into contacts values(NULL,'"+name+"','"+phone+"')");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void finalize()
    {
        try
        {
        connection.close();
        statement.close();
        super.finalize();
        }
        catch(Throwable ex)
        {
            //Do Nothing 
        }
    }
}
