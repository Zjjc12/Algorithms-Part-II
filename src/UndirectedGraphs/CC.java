package UndirectedGraphs;
import edu.princeton.cs.algs4.*;

public class CC
{
	// Keep a list of visited vertices
	private boolean[] marked;
	
	// Keep a list of connected components;
	private int[] id;
	
	// Number of connected components
	private int count;
	
	
	public CC(Graph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		
		// Loop through all vertices not visited, find vertices connected to it
		// Find all connected components
		for (int v = 0; v < G.V(); v++)
		{
			if (!marked[v])
			{
				dfs(G, v);
				count++;
			}
		}
	}
	
	public int count()
	{
		return count;
	}
	
	public int id(int v)
	{
		return id[v];
	}
	
	private void dfs(Graph G, int v)
	{
		// Set marked and set ID
		// All vertices discovered are in the same connected components
		marked[v] = true;
		id[v] = count;
		
		// Loop through adjacent vertices, see if they are marked and keep going deeper recursively
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
}
