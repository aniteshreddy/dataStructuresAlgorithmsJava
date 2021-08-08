package com.graphs.implementation;


public class GraphMain {

	public static void main(String[] args) {
		Graph graph=new Graph();
		
		graph.addNewEdges("Delhi", "Ahmedabad", false);
		graph.addNewEdges("Delhi", "Patna", false);
		graph.addNewEdges("Ahmedabad", "Indore", false);
		graph.addNewEdges("Indore", "Patna", false);
		graph.addNewEdges("Chennai", "Ahmedabad", false);
		graph.addNewEdges("Chennai", "Patna", false);
		
		System.out.println(graph);	
		System.out.println(graph.vertexes());
		System.out.println(graph.edges());
			
	}

}
