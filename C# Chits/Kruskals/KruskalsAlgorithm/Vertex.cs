using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KruskalsAlgorithm
{
    class Vertex
    {  
        public int nRank;
        public Vertex vRoot;
        public System.Drawing.Point pPosition;

        public int Name { get; set; }

        //Constructor to place object on the screen
        public Vertex(int nName, System.Drawing.Point pPosition)
        {
            this.Name = nName;
            nRank = 0;
            this.vRoot = this;
            this.pPosition = pPosition;
        }

        internal Vertex GetRoot()
        {
            if (this.vRoot != this)// am I my own root ? (am i the root ?)
            {
                this.vRoot = this.vRoot.GetRoot();// No? then get my root
            }
            return this.vRoot;
        }

        internal static void Join(Vertex vRoot1, Vertex vRoot2)
        {
            if (vRoot2.nRank < vRoot1.nRank)//is the rank of Root2 less than that of Root1 ?
            {
                vRoot2.vRoot = vRoot1;	//yes! then make Root1 the root of Root2 
                //(since it has the higher rank)
            }
            else //rank of Root2 is greater than or equal to that of Root1
            {
                vRoot1.vRoot = vRoot2;	//make Root2 the root of Root1
                if (vRoot1.nRank == vRoot2.nRank)//both ranks are equal ?
                {
                    vRoot1.nRank++;	//increment one of them, 
                    //we need to reach a single root for the whole tree
                }
            }
        }
    }
}
