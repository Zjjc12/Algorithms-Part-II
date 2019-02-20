package DirectedGraphs;

import edu.princeton.cs.algs4.*;

public class DepthFirstOrder
{
	private boolean[] marked;
	
	// Keep a stack of post order -> use to later reverse to make the topological order
	private Stack<Integer> reversePost;
	
	// DFS
	public DepthFirstOrder(Digraph G)
	{
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
		{
			if(!marked[v])
				dfs(G, v);
		}
	}
	
	
	private void dfs(Digraph G, int v)
	{
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
		// After finished w/ v, push to post order stack
		reversePost.push(v);
	}
	
	public Iterable<Integer> reversePost()
	{
		return reversePost;
	}
}
