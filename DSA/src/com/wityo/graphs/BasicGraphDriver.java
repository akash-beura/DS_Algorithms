package com.wityo.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Vertex implements Comparable<Vertex> {
	String relatedVertex;
	int weight;

	@Override
	public int compareTo(Vertex o) {
		return this.relatedVertex.compareTo(o.relatedVertex);
	}

}

class Graph {
	List<Set<Vertex>> adjList = new ArrayList<>();

	public void insert(int origin, Vertex destination) {
		if (adjList.get(0) == null) {
			Set<Vertex> vertices = new TreeSet<>();
			vertices.add(destination);
			adjList.add(origin, vertices);
		} else {
			adjList.get(origin).add(destination);
		}
	}
}

public class BasicGraphDriver {

	Graph g1 = new Graph();
	static List<String> vertices = new ArrayList<>();

	public static void inputVertex(String vertex) {
		vertices.add(vertex);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		System.out.println("How many vertices you want to enter?");
		num = sc.nextInt();
		System.out.println("Enter the vertices");
		for (int i = 0; i < num; i++) {
			System.out.println("Enter the vertex name");
			inputVertex(sc.next());
		}
		boolean continueInput = true;
		while (continueInput) {

		}

	}

}
