package com.graphs.prims;

import java.util.Arrays;

public class PrimsMain {

	public int minVertexSelection(int[] values, Boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int vertex = 0;
		for (int i = 0; i < values.length; i++) {
			
			if (visited[i] == false && values[i] < min) {

				min = values[i];
				vertex = i;
			}
		}
		return vertex;
	}

	public void mstGraph(int[][] nodes) {
		int v = nodes.length;
		int[] values = new int[v];
		Boolean[] visited = new Boolean[v];
		int[] parent = new int[v];
		Arrays.fill(visited, false);
		Arrays.fill(values, Integer.MAX_VALUE);

		values[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < v - 1; i++) {
			int minVertex = minVertexSelection(values, visited);
			visited[minVertex] = true;

			for (int j = 0; j < v; j++) {
				if (visited[j] == false && nodes[minVertex][j] != 0 && nodes[minVertex][j] < values[j]) {
					values[j] = nodes[minVertex][j];
					parent[j] = minVertex;
				}
			}

		}

		for (int i = 1; i < v ; i++) {
			System.out.println("Node " + i + "-->" + parent[i] + " weights -->" + values[i]);
		}

	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { { 0, 4, 6, 0, 0, 0 }, { 4, 0, 6, 3, 4, 0 }, { 6, 6, 0, 1, 8, 0 },
				{ 0, 3, 1, 0, 2, 3 }, { 0, 4, 8, 2, 0, 7 }, { 0, 0, 0, 3, 7, 0 } };
		new PrimsMain().mstGraph(graph);

	}
}
