//Invoking a web service
private void button1_Click(object sender, RoutedEventArgs e)
{
//here hello is the service reference
//any method defined in the service can be called in this manner
  hello.Service greeter = new hello.Service();
  textBox1.Text = greeter.HelloWorld(textBox1.Text);
}

