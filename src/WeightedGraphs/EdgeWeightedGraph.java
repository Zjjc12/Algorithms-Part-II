package WeightedGraphs;

import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedGraph
{
	// Number of vertices
	private final int V;
	
	// Keep a bag of adjacent vertices
	private final Bag<Edge>[] adj;
	
	
	public EdgeWeightedGraph(int V)
	{
		this.V = V;
		adj = (Bag<Edge>[]) new Bag[V];
		
		// Create a new bag for each vertex
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Edge>();
	}
	
	public void addEdge(Edge e)
	{
		// Add e to the adjacent list of both v and w
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}
}
