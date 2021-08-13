package com.trees.implementation;

public class TreeMain {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		
		System.out.println("Element found");
		System.out.println(bt.findNode(9));
		System.out.println("pre-order");
		bt.preOrderTraversal();
		System.out.println();
		System.out.println("InOrder-order");
		bt.inOrderTraversal();
		System.out.println();
		System.out.println("post-order");
		bt.postOrderTraversal();
		System.out.print("\nBreadth first search");
		bt.breadthFirstSearch();
		bt.depth();
		bt.minAndMax();
		bt.deleteNode(5);
		bt.inOrderTraversal();

	}
}
