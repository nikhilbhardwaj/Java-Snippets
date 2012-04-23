//Required Namespaces
using System.Xml;
using System.IO;

class Employee
{
  int _id;
  string _firstName;
  string _lastName;
  int _salary;
  public Employee(int id, string firstName, string lastName, int salary)
  {
    this._id = id;
    this._firstName = firstName;
    this._lastName = lastName;
    this._salary = salary;
  }
  public int Id { get { return _id; } }
  public string FirstName { get { return _firstName; } }
  public string LastName { get { return _lastName; } }
  public int Salary { get { return _salary; } }
}

//Writing XML
Employee[] employees = new Employee[4];
employees[0] = new Employee(1, "David", "Smith", 10000);
employees[1] = new Employee(3, "Mark", "Drinkwater", 30000);
employees[2] = new Employee(4, "Norah", "Miller", 20000);
employees[3] = new Employee(12, "Cecil", "Walker", 120000);

using (XmlWriter writer = XmlWriter.Create("employees.xml"))
{
  writer.WriteStartDocument();
  writer.WriteStartElement("Employees");

  foreach (Employee employee in employees)
  {
    writer.WriteStartElement("Employee");

    writer.WriteElementString("ID", employee.Id.ToString());
    writer.WriteElementString("FirstName", employee.FirstName);
    writer.WriteElementString("LastName", employee.LastName);
    writer.WriteElementString("Salary", employee.Salary.ToString());

    writer.WriteEndElement();
  }

  writer.WriteEndElement();
  writer.WriteEndDocument();
}

//Reading XML
Input text [perls.xml]

<?xml version="1.0" encoding="utf-8" ?>
<perls>
<article name="backgroundworker">
Example text.
</article>
<article name="threadpool">
More text.
</article>
<article></article>
<article>Final text.</article>
</perls>

// Create an XML reader for this file.
using (XmlReader reader = XmlReader.Create("perls.xml"))
{
  while (reader.Read())
  {
    // Only detect start elements.
    if (reader.IsStartElement())
    {
      // Get element name and switch on it.
      switch (reader.Name)
      {
        case "perls":
          // Detect this element.
          Console.WriteLine("Start <perls> element.");
          break;
        case "article":
          // Detect this article element.
          Console.WriteLine("Start <article> element.");
          // Search for the attribute name on this current node.
          string attribute = reader["name"];
          if (attribute != null)
          {
            Console.WriteLine("  Has attribute name: " + attribute);
          }
          // Next read will contain text.
          if (reader.Read())
          {
            Console.WriteLine("  Text node: " + reader.Value.Trim());
          }
          break;
      }
    }
  }
}

