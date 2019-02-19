package DirectedGraphs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.*;

public class WebCrawler
{
	public static void main(String[] args)
	{
		Queue<String> queue = new Queue<String>();
		SET<String> discovered = new SET<String>();

		String root = "http://www.stanford.edu";
		queue.enqueue(root);
		discovered.add(root);

		while (!queue.isEmpty())
		{
			String v = queue.dequeue();
			StdOut.println(v);
			
			String input = null;
			
            try {
    			In in = new In(v);
            	input = in.readAll().toLowerCase();
            }
            catch (IllegalArgumentException e) {
                StdOut.println("[could not open " + v + "]");
                StdOut.println(e);
                continue;
            }

			String regexp = "(http|https)://(\\w+\\.)+(edu|com|gov|org)";
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(input);

			while (matcher.find())
			{
				String w = matcher.group();
				if (!discovered.contains(w))
				{
					discovered.add(w);
					queue.enqueue(w);
				}

			}
		}
	}
}
