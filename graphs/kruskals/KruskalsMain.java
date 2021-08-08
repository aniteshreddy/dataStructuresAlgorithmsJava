package com.graphs.kruskals;

import java.util.Scanner;

import com.graphs.kruskals.Kruskals.Edge;;

public class KruskalsMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number of edges");
		int edges = scanner.nextInt();
		System.out.println("Enter total number of vertices");
		int vertices = scanner.nextInt();
		Edge input[] = new Edge[edges];
		Kruskals kruskals= new Kruskals();

		for (int i = 0; i < edges; i++) {
		
		input[i] = kruskals.new Edge();
		System.out.println("Enter Source ----> ");
		input[i].source=scanner.nextInt();
		System.out.println("Enter Destination ----> ");
		input[i].destination=scanner.nextInt();
		System.out.println("Enter Weight ----> ");
		input[i].weight=scanner.nextInt();
		
		}	
		kruskals.kruskalsImpl(input,edges,vertices);

	}

}
