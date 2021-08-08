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

		System.out.println(bt.findNode(9));
		bt.preOrderTraversal();
		System.out.println();
		bt.inOrderTraversal();
		System.out.println();
		bt.postOrderTraversal();
		bt.breadthFirstSearch();

	}
}
