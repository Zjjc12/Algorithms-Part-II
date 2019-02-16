import edu.princeton.cs.algs4.*;

public class DepthFirstPaths
{
	
	
	// Keep track of all vertices that it has already been to
	private boolean[] marked;
	
	// Where the path lead from
	private int[] edgeTo;
	
	// Starting point
	private int s;
	
	public DepthFirstPaths(Graph G, int s)
	{
		// Find vertices connected to s by marking vertices visited
		dfs(G, s);
	}
	
	// Algorithm that finds path to vertices by checking all unvisited vertices
	// Starting from v	
	private void dfs(Graph G, int v)
	{
		// Mark v because visited
		marked[v] = true;
		//For all adjacent vertices to v, if they are not marked, find the path from there
		for(int w : G.adj(v))
			if(!marked[w])
			{
				dfs(G, w);
				// Record that w came from v
				edgeTo[w]l = v;
			}
	}
	
	// Does s have a path to v	
	public boolean hasPathTo(int v) {
		// Return marked value, if marked then yes, else no
		return marked[v];
	}
	
	// Find the path to v
	public Iterable<Integer> pathTo(int v)
	{
		// Check if have a path first
		if(!hasPathTo(v))
			return null;
		// Make a stack of path
		Stack<Integer> path = new Stack<Integer>();
		// Going from s = v, push all the edgeTo to the stack making a path
		for(int x = v; x != s; x = edgeTo[x])
			path.push(x);
		
		path.push(s);
		
		// Return the path
		return path;
	}
}
