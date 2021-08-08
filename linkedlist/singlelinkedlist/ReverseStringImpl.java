package com.linkedlist.singlelinkedlist;



public class ReverseStringImpl {

	static Node<Object> head;

	static class Node<T extends Object> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	static void reverse() {
		Node<Object> prev = null;
		Node<Object> next = null;
		Node<Object> current = head;
//			System.out.println(current.data);	

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}

		head = prev;
		display();

	}

	static void display() {
		Node<Object> current = head;
		while (current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
		System.out.println(current.data);
	}

	public static void main(String[] args) {

		ReverseStringImpl.head = new Node<Object>(85);
		ReverseStringImpl.head.next = new Node<Object>(15);
		ReverseStringImpl.head.next.next = new Node<Object>(4);
		ReverseStringImpl.head.next.next.next = new Node<Object>(20);

		ReverseStringImpl.reverse();

	}

}
