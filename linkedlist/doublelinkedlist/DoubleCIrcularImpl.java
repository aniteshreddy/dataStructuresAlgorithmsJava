package com.linkedlist.doublelinkedlist;

import java.util.Scanner;

public class DoubleCIrcularImpl {

	public static void main(String[] args) {
		DoublyCircularLinked<Object> doublyList = new DoublyCircularLinked<>();
		
		doublyList.insert(1);
		doublyList.insert(45);
		doublyList.insert(3);
		doublyList.insert(8);
		doublyList.insert(5);
		doublyList.insert("bcd");
		doublyList.insert("mcd");
		doublyList.insert("ani");
		while (true) {
			System.out.println("Enter the Choice");
			Scanner scan = new Scanner(System.in);
			System.out.println("1.Insert element\n2.Delete element\n3.Traverse list\n4.Sort\n5.Exit");
			int key = scan.nextInt();
			
			
			
			
			switch (key) {
			case 1:
				System.out.println("Enter the Element");
				if (scan.hasNextInt())
					doublyList.insert(scan.nextInt());
				else {
					doublyList.insert(scan.next());
				}
				break;
			case 2:
				System.out.println("Enter element to be deleted");
				if (scan.hasNextInt())
					doublyList.delete(scan.nextInt());
				else {
					doublyList.delete(scan.next());
				}
				break;
			case 3:
				doublyList.display();
				break;
			case 4:
				doublyList.sort();
				break;
			case 5:
				System.out.println("Bye Bro!");
				System.exit(0);
				break;

			default:
				break;
			}
		}

	}

}
