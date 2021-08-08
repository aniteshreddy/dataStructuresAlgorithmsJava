package com.graphs.breadthdepthsearch;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class DFS {

	public void dfs(int start, int[][] arr,boolean[] visted) {
		
		visted[start]=true;
		System.out.println(start);
		for(int i=0;i<arr.length;i++) {
			if(!visted[i] && arr[start][i]!=0)
				dfs(i, arr, visted);
				
		}
		
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { { 0, 4, 6, 0, 0, 0 },  { 6, 0, 0, 1, 8, 0 },{ 4, 0, 0, 0, 4, 0 },
			 { 0, 4, 0, 0, 1, 7 }, { 0, 3, 1, 1, 0, 3 }, { 0, 0, 0, 3, 7, 0 } };
		boolean[] visited = new boolean[graph.length];
		Arrays.fill(visited, false);
		
		new DFS().dfs(0,graph,visited);
	}

}
