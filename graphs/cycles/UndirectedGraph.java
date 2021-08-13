package com.graphs.cycles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {

	private int[][] adjMatrix;
	private int numVertices;

	public UndirectedGraph(int numVertices) {

		this.numVertices = numVertices;
		adjMatrix = new int[numVertices][numVertices];

		Arrays.stream(adjMatrix).forEach(e -> Arrays.fill(e, 0));
//		Arrays.stream(adjMatrix).forEach(e -> Arrays.stream(e).forEach(System.out::println));

	}

	public void addEdge(int source, int destination) {
		adjMatrix[source][destination] = 1;
		adjMatrix[destination][source] = 1;
	}

	public boolean findCycle() {

//		boolean[] visited = new boolean[numVertices];
		int[] visitedVertex = new int[numVertices];
		Arrays.fill(visitedVertex, -1);

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);

		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			visitedVertex[vertex] = 1;

			for (int i = 0; i < numVertices; i++) {

				if (visitedVertex[i] == 0 && adjMatrix[vertex][i] != 0 ) {
					return true;
				}

				else if (adjMatrix[vertex][i] != 0 && visitedVertex[i] == -1) {

					visitedVertex[i] = 0;
					queue.add(i);

				}

					}
		}

		return false;

	}

	public static void main(String[] args) {

		UndirectedGraph undirectedGraph = new UndirectedGraph(5);
		undirectedGraph.addEdge(1, 0);
		undirectedGraph.addEdge(4, 0);
		undirectedGraph.addEdge(1, 3);
		undirectedGraph.addEdge(1, 4);
		undirectedGraph.addEdge(1, 2);
		undirectedGraph.addEdge(3, 4);
		undirectedGraph.addEdge(2, 3);

		System.out.println(undirectedGraph.findCycle());

	}

}
