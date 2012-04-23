using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KruskalsAlgorithm
{
    class Edge : IComparable
    {
        Vertex v1, v2;
        int nCost;
        //System.Drawing.Point pStringPosition;

        public Vertex V1
        {
            get
            {
                return v1;
            }
        }
        public Vertex V2
        {
            get
            {
                return v2;
            }
        }
        public int Cost
        {
            get
            {
                return nCost;
            }
        }
        //public System.Drawing.Point StringPosition
        //{
        //    get
        //    {
        //        return pStringPosition;
        //    }
        //}

        public Edge(Vertex v1, Vertex v2, int nCost)//, System.Drawing.Point pStringPosition)
        {
            this.v1 = v1;
            this.v2 = v2;
            this.nCost = nCost;
            //this.pStringPosition = pStringPosition;
        }  

        public int CompareTo(object obj)
        {
            Edge e = (Edge)obj;
            return this.nCost.CompareTo(e.nCost);
        } 
    }
}
