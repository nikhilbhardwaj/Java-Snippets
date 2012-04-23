//EmptyDatabase.mdb is a blank database and the function to create a table is defined here
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.OleDb;

namespace DBDemo
{
  class Program
  {
    const string connectionString = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\Users\USER\Documents\Visual Studio 11\Projects\DBDemo\DogsDatabase.mdb";

    static void Main(string[] args)
    {
      TryCreateTable();
      while (true)
      {
        Console.WriteLine("INPUT TYPE:\tWeight,Name,Breed\tor\tSELECT:");
        string[] input = Console.ReadLine().Split(',');
        try
        {
          char c = char.ToLower(input[0][0]);
          if (c == 's')
          {
            DisplayDogs();
            continue;
          }
          int weight = int.Parse(input[0]);
          string name = input[1];
          string breed = input[2];
          AddDog(weight, name, breed);
        }
        catch
        {
          Console.WriteLine("Input error");
        }
      }
    }

    //Method to create the table if it doesn't exist
    static void TryCreateTable()
    {
      using (OleDbConnection con = new OleDbConnection(connectionString))
      {
        con.Open();
        try
        {
          using (OleDbCommand command = new OleDbCommand("CREATE TABLE Dogs1 (Weight INT, Name TEXT, Breed TEXT)", con))
          {
            command.ExecuteNonQuery();
          }
        }
        catch
        {
          Console.WriteLine("Table couldn't be created.");
        }
      }
    }

    //Method to add a dog into the table
    static void AddDog(int weight, string name, string breed)
    {
      using (OleDbConnection con = new OleDbConnection(connectionString))
      {
        con.Open();
        try
        {
          using (OleDbCommand command = new OleDbCommand("INSERT INTO Dogs1 VALUES(@Weight, @Name, @Breed)", con))
          {
            command.Parameters.Add(new OleDbParameter("Weight", weight));
            command.Parameters.Add(new OleDbParameter("Name", name));
            command.Parameters.Add(new OleDbParameter("Breed", breed));
            command.ExecuteNonQuery();
          }
        }
        catch
        {
          Console.WriteLine("Count not insert.");
        }
      }
    }

    //Method to display all the elements from the database
    static void DisplayDogs()
    {
      List<Dog> dogs = new List<Dog>();
      using (OleDbConnection con = new OleDbConnection(connectionString))
      {
        con.Open();

        using (OleDbCommand command = new OleDbCommand("SELECT * FROM Dogs1", con))
        {
          OleDbDataReader reader = command.ExecuteReader();
          while (reader.Read())
          {
            int weight = reader.GetInt32(0);    // Weight int
            string name = reader.GetString(1);  // Name string
            string breed = reader.GetString(2); // Breed string
            dogs.Add(new Dog() { Weight = weight, Name = name, Breed = breed });
          }
        }
      }
      foreach (Dog dog in dogs)
      {
        Console.WriteLine(dog);
      }
    }
  }

  //Change the class to represent whatever you want
  public class Dog
  {
    public int Weight { get; set; }
    public string Name { get; set; }
    public string Breed { get; set; }
    public override string ToString()
    {
      return string.Format("Weight: {0}, Name: {1}, Breed: {2}",
          Weight, Name, Breed);
    }
  }
}
