package com.trees.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node rootNode;

	class Node {
		int data;
		Node leftNode;
		Node rightNode;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node addRecursive(Node current, int value) {
		if (current == null)
			return new Node(value);
		if (current.data < value) {
			current.rightNode = addRecursive(current.rightNode, value);
		} else if (current.data > value) {
			current.leftNode = addRecursive(current.leftNode, value);
		} else {
			return current;
		}
		return current;
	}

	public void add(int value) {
		rootNode = addRecursive(rootNode, value);

	}

	private boolean findRecursive(Node currentNode, int value) {
		if (currentNode == null) {
			return false;
		} else if (currentNode.data == value) {
			return true;
		} else {
			return value > currentNode.data ? findRecursive(currentNode.rightNode, value)
					: findRecursive(currentNode.leftNode, value);
		}

	}

	public boolean findNode(int value) {
		return findRecursive(rootNode, value);
	}

	private Node deleteNodeRecursive(Node currentNode, int value) {
		if (currentNode == null)
			return null;
		if (currentNode.data > value)
			currentNode.leftNode= deleteNodeRecursive(currentNode.leftNode, value);
		else if (currentNode.data < value)
			currentNode.rightNode= deleteNodeRecursive(currentNode.rightNode, value);
		else {
			if (currentNode.rightNode == null && currentNode.leftNode == null) {
				 currentNode= null;
				return currentNode;
			}
			else if (currentNode.leftNode != null) {
				currentNode.data = predessor(currentNode.leftNode);
				currentNode.leftNode = deleteNodeRecursive(currentNode.leftNode, currentNode.data);
			} else {
				currentNode.data = successor(currentNode.rightNode);
				currentNode.rightNode = deleteNodeRecursive(currentNode.rightNode, currentNode.data);
			}
		}
		return currentNode;
	}

	private int predessor(Node current) {
		while (current.rightNode != null) {
			current = current.rightNode;
		}
		return current.data;

	}

	private int successor(Node current) {
		while (current.leftNode != null) {
			current = current.leftNode;
		}
		return current.data;

	}

	public void deleteNode(int value) {
		rootNode = deleteNodeRecursive(rootNode, value);
	}

	private void preOrder(Node currentNode) {
		if (currentNode != null) {

			System.out.print(currentNode.data + " ");
			preOrder(currentNode.leftNode);
			preOrder(currentNode.rightNode);
		}
	}

	private void inOrder(Node currentNode) {
		if (currentNode != null) {

			inOrder(currentNode.leftNode);
			System.out.print(currentNode.data + " ");

			inOrder(currentNode.rightNode);
		}
	}

	private void postOrder(Node currentNode) {
		if (currentNode != null) {

			postOrder(currentNode.leftNode);
			postOrder(currentNode.rightNode);
			System.out.print(currentNode.data + " ");
		}
	}

	public void inOrderTraversal() {
		inOrder(rootNode);
	}

	public void postOrderTraversal() {
		postOrder(rootNode);
	}

	public void preOrderTraversal() {
		preOrder(rootNode);
	}

	public void breadthFirstSearch() {
		System.out.println();
		if (rootNode == null)
			return;

		Queue<Node> nodes = new LinkedList<>();
		nodes.add(rootNode);

		while (!nodes.isEmpty()) {
			Node node = nodes.poll();
			System.out.print(node.data + " ");
			if (node.leftNode != null)
				nodes.add(node.leftNode);
			if (node.rightNode != null)
				nodes.add(node.rightNode);
		}

	}

	private int depthOfTree(Node currentNode) {
		if (currentNode == null)
			return 0;
		else {
			int left = depthOfTree(currentNode.leftNode);
			int right = depthOfTree(currentNode.rightNode);
			return Math.max(left, right) +1 ;
		}
	}

	public void depth() {
		System.out.println("\ndepth of tree " + depthOfTree(rootNode));
	}
	
	public void minAndMax() {
		Node currentNode = rootNode;
		while(currentNode.leftNode!=null)
			currentNode=currentNode.leftNode;
		
		System.out.println("least value "+ currentNode.data);
		
		currentNode=rootNode;
		
		while (currentNode.rightNode!=null) {
			currentNode=currentNode.rightNode;
		}
		System.out.println("highest value "+ currentNode.data);
	}

}
