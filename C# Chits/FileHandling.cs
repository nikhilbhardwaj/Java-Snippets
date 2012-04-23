// Read in a file line-by-line, and store it all in a List.
//
List<string> list = new List<string>();
using (StreamReader reader = new StreamReader("file.txt"))
{
  string line;
  while ((line = reader.ReadLine()) != null)
  {
    list.Add(line); // Add to list.
    Console.WriteLine(line); // Write to console.
  }
}

//To read all text into a string
string file = File.ReadAllText("C:\\file.txt");

//Writing text
using (StreamWriter writer = new StreamWriter("important.txt"))
{
  writer.Write("Word ");
  writer.WriteLine("word 2");
  writer.WriteLine("Line");
}

//To append text
StreamWriter writer = new StreamWriter("C:\\log.txt", true);

//My text processor
openFileDialog1 = new OpenFileDialog();
if (openFileDialog1.ShowDialog() == DialogResult.OK)
{
  string fileContents = File.ReadAllText(openFileDialog1.FileName);
  int startIndex = 0, endIndex = 0, bodyStart, bodyEnd, newId;
  while (startIndex >= 0)
  {
    startIndex = endIndex = 0;
    //to find the beginnig and the end of the reuters tag
    startIndex = fileContents.IndexOf("<REUTERS", StringComparison.OrdinalIgnoreCase);
    if (startIndex > 0)
    {
      endIndex = fileContents.IndexOf("/REUTERS", startIndex, StringComparison.OrdinalIgnoreCase);
    }
    if (startIndex >= 0 && endIndex >= 0)
    {
      newId = fileContents.IndexOf("NEWID=", startIndex);
      string fileName = fileContents.Substring(newId + 7, 5);
      string fullTagContents = fileContents.Substring(startIndex, endIndex - startIndex);
      bodyStart = fullTagContents.IndexOf("<BODY>", startIndex, StringComparison.OrdinalIgnoreCase);
      bodyEnd = fullTagContents.IndexOf("</BODY>", startIndex, StringComparison.OrdinalIgnoreCase);
      if (bodyStart > 0)
      {
        //if the body is empty then we skip it
        if (bodyStart < fullTagContents.Length && bodyEnd < fullTagContents.Length)
        {
          richTextBox1.Text = fullTagContents.Substring(bodyStart + 6, (bodyEnd - bodyStart) - 6);
        }
        //richTextBox1.Text += "\n FileName " + fileName;

        //code to write to a new file
        System.IO.File.WriteAllText(fileName + ".txt", richTextBox1.Text);
      }
      fileContents = fileContents.Substring(endIndex + 5);
    }
  }
}


