package binarysearchtree;

import java.util.Scanner;

public class BSTDriver {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);
		int choice;
		int data;
		do {
			System.out.println("1. Insert Data");
			System.out.println("2. Search Data");
			System.out.println("3. Level Order Traversal");
			System.out.println("4. Pre Order Traversal");
			System.out.println("5. In Order Traversal");
			System.out.println("6. Post Order Traversal");
			System.out.println("7. Delete data from BST");
			System.out.println("8. Exit");
			choice = sc.nextInt();
			if(choice == 1) {
				System.out.println("Enter Data");
				data = sc.nextInt();
				tree.root = tree.insertNode(data, tree.root);
				System.out.println("Data inserted");
			} else if(choice == 2) {
				System.out.println("Enter Data");
				data = sc.nextInt();
				tree.search(tree.root, data);
			} else if(choice == 3) {
				tree.levelOrderTraversal(tree.root);
			} else if(choice == 4) {
				System.out.println("PRE ORDER TRAVERSAL:-");
				tree.preOrder(tree.root);
			} else if(choice == 5) {
				System.out.println("IN ORDER TRAVERSAL:-");
				tree.inOrder(tree.root);
			} else if(choice == 6) {
				System.out.println("POST ORDER TRAVERSAL:-");
				tree.postOrder(tree.root);
			} else if(choice == 7) {
				data = sc.nextInt();
				tree.root = tree.delete(tree.root, data);				
			}
		}while(choice!=8);
		
		sc.close();
	}

}
