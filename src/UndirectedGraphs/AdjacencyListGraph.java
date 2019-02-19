package UndirectedGraphs;
import edu.princeton.cs.algs4.*;

public class AdjacencyListGraph
{
	private final int V;
	private Bag<Integer>[] adj;
	
	// An array of all vertices store their adjacent verticies in a bag
	public AdjacencyListGraph(int V)
	{
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}
	
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
}
