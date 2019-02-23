package DirectedGraphs;

import edu.princeton.cs.algs4.Digraph;

public class KosarajuSharirSCC
{
	private boolean marked[];
	private int[] id;
	private int count;
	
	// Compute topological order
	// Run DFS visiting unmarked vertices to create strong components
	public KosarajuSharirSCC(Digraph G)
	{
		marked = new boolean[G.V()];
		id = new int[G.V()];
		
		// Find topological order
		DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());
		
		for(int v : dfs.reversePost())
		{
			if(!marked[v])
			{
				dfs(G, v);
				// Everytime go to another dfs, add 1 to ID
				count++;
			}
		}
	}
	
	// Depth First Search
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		// Set ID as current count
		id[v] = count;
		for(int w :  G.adj(v))
			if(!marked[w])
				dfs(G, w);
	}
}
