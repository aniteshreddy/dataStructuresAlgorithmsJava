package com.graphs.cycles;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DirectedGraph {
	private int[][] adjMatrix;
	private int numVertices=0;

	public DirectedGraph(int numVertices) {

		this.numVertices = numVertices;
		adjMatrix = new int[numVertices][numVertices];

	}


	public boolean findCycles(Stack<Integer> visitedStack, int[] visitingPos) {

		while (!visitedStack.isEmpty()) {
			int current = visitedStack.pop();

			for (int i = 0; i < visitingPos.length; i++) {

				if (adjMatrix[current][i] != 0 && visitingPos[i] == 0) {
					return true;
				} else if (adjMatrix[current][i] != 0 && visitingPos[i] == -1) {
					visitingPos[i] = 0;
					visitedStack.push(i);
				if(	visitingPos[i] == 0 && findCycles(visitedStack, visitingPos)) {
					return true;
				}
				

				}

			}
			visitingPos[current] = 1;

		}

		return false;

	}

	public void addEdge(int source, int destination) {
		adjMatrix[source][destination] = 1;
	}

	public static void main(String[] args) {
		DirectedGraph undirectedGraph = new DirectedGraph(5);

		undirectedGraph.addEdge(0, 1);
		undirectedGraph.addEdge(0, 2);
		undirectedGraph.addEdge(1, 2);
		undirectedGraph.addEdge(1, 3);
		undirectedGraph.addEdge(3, 4);
		undirectedGraph.addEdge(4, 1);

		Stack<Integer> visitedStack = new Stack<>();
		int[] visitingPos = new int[5];
		Arrays.fill(visitingPos, -1);
		visitingPos[0] = 0;
		visitedStack.add(0);

		System.out.println(undirectedGraph.findCycles(visitedStack, visitingPos));
	}

}
