package com.graphs.dijkstras;

import java.util.Arrays;

import sun.security.util.Length;

public class DijkstrasAlgo {

	private int selectMinValue(int[] values, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int vertex = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] < min && !visited[i]) {
				min = values[i];
				vertex = i;

			}
		}

		return vertex;
	}

	public void djkstrasImpl(int[][] graph) {
		int size = graph.length;
		boolean[] visited = new boolean[size];
		int[] values = new int[size];
		int[] parent = new int[size];
		Arrays.fill(visited, false);
		Arrays.fill(parent, -1);
		Arrays.fill(values, Integer.MAX_VALUE);
		parent[0] = 0;
		values[0] = 0;

		for (int i = 0; i < size - 1; i++) {
			int minVertex = selectMinValue(values, visited);
			visited[i] = true;

			for (int j = 0; j < size; j++) {
				if (!visited[j] && graph[minVertex][j] != 0
						&& graph[minVertex][j] + values[minVertex] < values[j]) {
					values[j] = graph[minVertex][j] + values[minVertex];
					parent[j] = minVertex;
				}
			}

		}
		
		for(int i=1;i<size;i++) {
			System.out.println(parent[i]+"-->"+i+"-->" +graph[parent[i]][i] );
		}
		

	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 1, 4, 0, 0, 0 }, { 1, 0, 4, 2, 7, 0 }, { 4, 4, 0, 3, 5, 0 },
				{ 0, 2, 3, 0, 4, 6 }, { 0, 7, 5, 4, 0, 7 }, { 0, 0, 0, 6, 7, 0 } };

				new DijkstrasAlgo().djkstrasImpl(graph);
				
				
		
	}

}
