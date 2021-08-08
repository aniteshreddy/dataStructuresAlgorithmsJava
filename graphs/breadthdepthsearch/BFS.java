package com.graphs.breadthdepthsearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public void bfs(int[][] arr) {
		boolean[] visited = new boolean[arr.length];
		Arrays.fill(visited, false);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			for (int j = 0; j < arr[current].length; j++) {
				if (!visited[j] && arr[current][j] != 0) {
					queue.add(j);
					visited[j] = true;
				}
			}

		}

	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { { 0, 1, 1, 0, 0, 0 }, { 6, 0, 0, 0, 8, 0 }, { 0, 3, 0, 0, 2, 3 },
				{ 4, 0, 0, 3, 4, 0 }, { 0, 4, 8, 2, 1, 7 }, { 0, 0, 0, 3, 7, 0 } };

		new BFS().bfs(graph);
	}
}
