package UndirectedGraphs;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;

public class BreadthFirstPaths
{
	// Keep a list of visited vertices
	private boolean[] marked;
	// Keep a list of where the search came from
	private int[] edgeTo;
	
	// Finds the path to each vertice by going in "layers" visiting all vertices in one layer first
	private void bfs(Graph G, int s)
	{
		// Makes a new queue of integers storing unvisited vertices
		Queue<Integer> q = new Queue<Integer>();
		// Put s on queue and marked it as visited
		q.enqueue(s);
		marked[s] = true;
		while(!q.isEmpty())
		{
			// Get unvisited vertex
			int v = q.dequeue();
			// Find all adjacent vertices
			for(int w : G.adj(v))
			{
				// If not marked yet, mark it and add it to queue
				if(!marked[w])
				{
					q.enqueue(w);
					marked[w] = true;
					// Add the path it came from v
					edgeTo[w] = v;
				}
			}
		}
	}
}
