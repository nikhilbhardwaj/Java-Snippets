using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GraphicsDemo
{
  public partial class Form1 : Form
  {
    Graphics g;
    public Form1()
    {
      InitializeComponent();
      g = this.CreateGraphics();
    }

    private void Form1_Paint(object sender, PaintEventArgs e)
    {
      Point[] trianglePoints = new Point[3];
      trianglePoints[0] = new Point(100, 10);
      trianglePoints[1] = new Point(100, 100);
      trianglePoints[2] = new Point(200, 55);
      g.FillPolygon(Brushes.Black, trianglePoints);
    }
  }
}

