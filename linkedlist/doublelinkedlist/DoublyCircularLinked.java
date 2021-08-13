package com.linkedlist.doublelinkedlist;

import java.util.Comparator;

public class DoublyCircularLinked<T extends Object> implements Comparator<T> {
	public Node start = null;

	class Node {
		T data;
		Node next;
		Node previous;

	}

	@Override
	public int compare(T argo, T arg1) {
		if (argo instanceof Integer) {
			if (arg1 instanceof Integer) {

				int i = (int) arg1;
				int j = (int) argo;
				return j - i;
			}
			return -1;
		} else if (arg1 instanceof String) {
			if (argo instanceof String) {
				return ((String) argo).compareTo((String) arg1);
			} else {
				return 1;
			}
		}
		return 0;
	}

	public void insert(T n) {
		if (start == null) {

			Node new_node = new Node();
			new_node.data = n;
			start = new_node.next = new_node.previous = new_node;
			return;
		}
		Node new_node = new Node();
		new_node.data = n;
		Node last = start.previous;

		new_node.next = start;
		new_node.previous = last;
		last.next = start.previous = new_node;

	}

	void delete(T n) {
		if (start == null)
			return;
		else if (start.next == start) {
			start = null;
		} else if (start.data.equals(n)) {
			Node last = start.previous;
			Node next = start.next;
			next.previous = last;
			last.next = next;
			start = last.next;
			return;

		} else if (start.previous.data.equals(n)) {
			Node last = start.previous;
			last.previous.next = start;
			start.previous = last.previous;
			return;
		}

		else {
			Node current = start;
			while (current.next != start) {
				if (current.data.equals(n)) {
					Node last = current.previous;
					last.next = current.next;
					current.next.previous = last;
					return;
				}
				current = current.next;

			}
			return;
		}
		System.out.println("Nothing found to delete");
	}

	void display() {
		Node current = start;
		if (start == null) {
			System.out.println("Nothing to print");
			return;
		} else if (start.next == start) {
			System.out.println(start.data);
			return;
		}
		while (current.next != start) {
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);
	}

	void sort() {
		if (start == null) {
			
		} else if (start.next == start) {
			System.out.println(start.data);
			
		} else {
			Node current = start;
			Node index = current.next;
			do {

				do {
					if (compare(current.data, index.data) < 0) {
						T temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}while (index != start);
				current = current.next;
			} while (current != start);
		}
	}

}
