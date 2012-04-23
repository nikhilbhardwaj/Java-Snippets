using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace KruskalsAlgorithm
{
    public partial class Form1 : Form
    {
        private List<Vertex> graphVertices;
        private List<Edge> graphEdges, minEdges;
        private Graphics g;
        private Pen pen = new Pen(Color.Red);
        int vertexCount, mst_cost;
        bool drawLines;
        //The initial graph this represents is in a jpeg file within the same directory
        const string filePath = @"C:\Documents and Settings\205110018\Desktop\VS\KruskalsAlgorithm\KruskalsAlgorithm\edgelist1.txt";

        public Form1()
        {
            InitializeComponent();
            vertexCount = 0;
            mst_cost = 0;
            graphEdges = new List<Edge>();
            graphVertices = new List<Vertex>();
            g = this.CreateGraphics();
            MessageBox.Show("Plot the points on the screen");
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            foreach (Vertex v in graphVertices)
            {
                //Get the coordinates of the point
                Point p = v.pPosition;
                g.FillEllipse(Brushes.Red, p.X, p.Y, 10, 10);
                String tmpName = ((char)('A' + (char)v.Name)).ToString();
                g.DrawString(tmpName, (Font) button1.Font.Clone(), Brushes.Red, new Point(p.X, p.Y - 12));
            }

            if (drawLines)
            {
                //Code to connect the components
                foreach (Edge edg in minEdges)
                {
                    DrawEdge(edg, g);
                }
            }
        }

        private void Form1_DoubleClick(object sender, EventArgs e)
        {
            MouseEventArgs me = e as MouseEventArgs;

            MouseButtons buttonPushed = me.Button;
            int xPos = me.X;
            int yPos = me.Y;

            graphVertices.Add(new Vertex(vertexCount++, new Point(xPos,yPos)));
   
            this.Refresh();
        }

        private void DrawEdge(Edge edg, Graphics g)
        {
            g.DrawLine(Pens.Black, edg.V1.pPosition, edg.V2.pPosition);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            StreamReader fin;
            try
            {
                string line;
                fin = new StreamReader(filePath);
                while ((line = fin.ReadLine()) != null)
                {
                    string[] lineContents = line.Split();
                    Vertex v1 = GetVertexByName(Convert.ToInt32(lineContents[0]));
                    Vertex v2 = GetVertexByName(Convert.ToInt32(lineContents[1]));
                    int cost = Convert.ToInt32(lineContents[2]);
                    graphEdges.Add(new Edge(v1,v2,cost));
                }

                fin.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("File Error" + ex.ToString());
                
            }
            //now to solve and find a minimum spannig tree
            minEdges = Graph.SolveGraph(graphEdges, ref mst_cost);
            drawLines = true;
        }

        private Vertex GetVertexByName(int name)
        {
            foreach (Vertex v in graphVertices)
            {
                if(v.Name == name)
                {
                    return v;
                }
            }
            MessageBox.Show("Invalid contents in the text file");
            return null;
        }
    }
}
