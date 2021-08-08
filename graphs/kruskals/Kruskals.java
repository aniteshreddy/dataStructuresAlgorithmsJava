package com.graphs.kruskals;

import java.util.Arrays;
import java.util.PrimitiveIterator.OfDouble;

public class Kruskals {

	public class Edge implements Comparable<Edge> {
		int source;
		int destination;
		int weight;

		public Edge() {

		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	public void kruskalsImpl(Edge[] inputEdges, int edges, int vertices) {
		int newEdges = 0;
		Arrays.sort(inputEdges);
		Edge[] outputEdges = new Edge[vertices - 1];
		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; i++)
			parent[i] = i;
		for (int i = 0; i < edges; i++) {
			if (newEdges >= vertices - 1) {
				break;
			}
			Edge currentEdge = inputEdges[i];
			int sourceParent = findParent(parent, currentEdge.source);
			int destinationParent = findParent(parent, currentEdge.destination);
			if (sourceParent != destinationParent) {
				outputEdges[newEdges] = currentEdge;
				newEdges++;
				parent[sourceParent] = destinationParent;
			}
		}
		System.out.println("The minimum spanning tree of given edges is");

		for (Edge e : outputEdges) {

			System.out.println(e.source + " ---> " + e.destination + "---> weight is --->" + e.weight);
		}

	}

	private int findParent(int[] parent, int v) {
		if (parent[v] == v) {
			return v;
		}
		return findParent(parent, parent[v]);
	}

}
