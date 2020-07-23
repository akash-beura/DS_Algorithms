package com.wityo.dynamicprogramming.bellmanford;

class Edge {

	int source;
	int destination;
	int weight;

	public Edge() {
		// TODO Auto-generated constructor stub
	}

	public Edge(int source, int destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

}

class Graph {
	Edge[] edge;
	int v, e;

	public Graph(int V, int E) {
		v = V;
		e = E;
		edge = new Edge[e];
		for (int i = 0; i < edge.length; i++) {
			edge[i] = new Edge();
		}
	}

	// function to find the min distance to all other vertices.
	void bellmanFord(Graph graph, int src) {
		int V = graph.v;
		int E = graph.e;
		int dist[] = new int[V];
		for (int i = 1; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < V; i++) {
			for (int j = 0; j < V; j++) {
				int u = graph.edge[j].source;
				int v = graph.edge[j].destination;
				int edgeWeight = graph.edge[j].weight; // c(u,v)
				int distanceU = dist[u];
				if (distanceU != Integer.MAX_VALUE && distanceU + edgeWeight < dist[v]) {
					dist[v] = distanceU + edgeWeight;
				}
			}
		}
	}
}

public class BellmanFord {

}
