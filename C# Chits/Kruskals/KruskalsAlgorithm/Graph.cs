using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KruskalsAlgorithm
{
    class Graph
    {
        public static List<Edge> SolveGraph(List<Edge> m_lstEdgesInitial,ref int nTotalCost)
        {
            m_lstEdgesInitial.Sort();
            //Edge.QuickSort(m_lstEdgesInitial, 0, m_lstEdgesInitial.Count - 1);
            List<Edge> finalEdgesList = new List<Edge>(m_lstEdgesInitial.Count);
            foreach (Edge ed in m_lstEdgesInitial)
            {
                Vertex vRoot1, vRoot2;
                vRoot1 = ed.V1.GetRoot();
                vRoot2 = ed.V2.GetRoot();
                if (vRoot1.Name != vRoot2.Name)
                {
                    nTotalCost += ed.Cost;
                    Vertex.Join(vRoot1, vRoot2);
                    finalEdgesList.Add(new Edge(ed.V1, ed.V2, ed.Cost));
                }
            }
            return finalEdgesList;
        }
    }
}
