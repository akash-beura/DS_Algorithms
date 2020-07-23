package graphs;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {
	private int V;
	private LinkedList<Integer>[] adj;

	Graph(final int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		if (adj != null) {
			adj[v].add(w);
		}
	}

	public void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println(v);

		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	public void DFS(int start) {
		boolean visited[] = new boolean[V];
		DFSUtil(start, visited);
	}

}

public class GraphTraversal {
	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
	}
}
