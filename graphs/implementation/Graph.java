package com.graphs.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<String, List<String>> map = new HashMap<>();
		

	public void addVertex(String source) {
		map.put(source, new LinkedList<>());
	}

	public void addNewEdges(String source, String destination, boolean bidirectional) {
		if (!map.containsKey(source))
			addVertex(source);
		if (!map.containsKey(destination))
			addVertex(destination);
		map.get(source).add(destination);
		if (bidirectional)
			map.get(destination).add(source);

	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (String key : map.keySet()) {
			builder.append(key + " : ");
			for (String value : map.get(key)) {
				builder.append(value + " ");
			}
			builder.append("\n");
		}	
		return builder.toString();
	}

	public int vertexes() {
		return map.keySet().size();
	}

	public int edges() {
		int sum = 0;
		StringBuilder builder = new StringBuilder();
		ArrayList<String> visited = new ArrayList<>();
		for (String key : map.keySet()) {
			visited.add(key);
			for (String value : map.get(key)) {
				if (visited.contains(value) && map.get(value).contains(key)) {
					continue;
				} else {
					sum += 1;
				}
			}
		}
		return sum;
	}

}
