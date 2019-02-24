package WeightedGraphs;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.Edge;


public class KruskalMST
{
	// MST queue
	private Queue<Edge> mst = new Queue<Edge>();
	
	// 1. Sort edges by weight in ascending order
	// 2. Add edge to MST unless that edge creates a cycle
	public KruskalMST(EdgeWeightedGraph G)
	{
		// Keep a min priority queue for weights 
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e: G.edges())
			pq.insert(e);
		
		// Keep a union find data structure for easy loop checks.
		UF uf = new UF(G.V());
		
		// While there are still edges and the total amount isn't v - 1 (If more its cyclic)
		while (!pq.isEmpty() && mst.size() < G.V() - 1)
		{
			// Use the minimum 
			Edge e = pq.delMin();
			
			// Find its vertices
			int v = e.either(), w = e.other(v);
			
			// If they are not connected (cyclic), then add it to connected component and add e to MST
			if(!uf.connected(v, w))
			{
				uf.union(v, w);
				mst.enqueue(e);
			}
		}
	}
	
	public Iterable<Edge> edges()
	{
		return mst;
	}
}
