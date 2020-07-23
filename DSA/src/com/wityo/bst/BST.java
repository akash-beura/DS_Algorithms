package com.wityo.bst;

import java.util.ArrayList;
import java.util.List;

class Node {
	Node left;
	Node right;
	int data;
}

class QueueNode {
	Node data;
	QueueNode next;
}

class Queue {
	private QueueNode front;
	private QueueNode rear;

	public boolean isEmpty() {
		if (front == null && rear == null) {
			return true;
		}
		return false;
	}

	public void enqueue(Node data) {
		QueueNode node = new QueueNode();
		node.data = data;
		if (isEmpty()) {
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
	}

	public Node deQueue() {
		Node temp = front.data;
		if (!isEmpty()) {
			if (front == rear) {
				front = rear = null;
			} else {
				front = front.next;
			}
		}
		return temp;
	}

	public Node front() {
		if (front == null)
			return null;
		return front.data;
	}

	public int size() {
		if (front == null && rear == null) {
			return 0;
		} else {
			QueueNode temp = front;
			int count = 0;
			while (temp != null) {
				temp = temp.next;
				count++;
			}
			return count;
		}

	}
}

public class BST {
	Node root;

	public Node createNode(int data) {
		Node node = new Node();
		node.data = data;
		return node;
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			root = createNode(data);
		} else if (data <= root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public Node searchNode(Node root, int data) {
		if (root == null) {
			System.out.println("No data as such found");
		} else if (root.data == data) {
			System.out.println("Data found");
		} else if (data > root.data) {
			searchNode(root.right, data);
		} else {
			searchNode(root.left, data);
		}
		return root;
	}

	public void maxElement() {
		Node temp = root;
		while (temp.right != null)
			temp = temp.right;
		System.out.println("Largest data in the tree is:" + temp.data);
	}

	public Node minElement() {
		Node temp = root;
		while (temp.left != null)
			temp = temp.left;
		return temp;
	}

	public Node minElement(Node root) {
		Node temp = root;
		while (temp.left != null)
			temp = temp.left;
		return temp;
	}

	public int totalNodes(Node root) {
		if (root == null) {
			return 0;
		}
		return totalNodes(root.left) + 1 + totalNodes(root.right);
	}

	private int max(int a, int b) {
		if (a == b)
			return a;
		else if (a > b)
			return a;
		else
			return b;
	}

	public int findHeight(Node root) {
		if (root == null) {
			return -1;
		}
		return max(findHeight(root.left), findHeight(root.right)) + 1;
	}

	// Depth first search using recursion
	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		inOrder(root.right);
		System.out.println(root.data);
	}

	public void bfs(Node root) {
		Queue queue = new Queue();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node temp = queue.deQueue();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				queue.enqueue(temp.left);
			if (temp.right != null)
				queue.enqueue(temp.right);

		}
	}

	public Node delete(Node root, int data) {
		if (root == null) {
			return root;
		} else if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else {
			// case 1 if both the left and right are null
			if (root.left == null && root.right == null) {
				root = null;
			}
			// Case2: if only left child exists
			else if (root.right == null) {
				root = root.left;
			} else if (root.left == null) {
				root = root.right;
			} else {
				Node temp = minElement(root);
				System.out.println(temp.data + "+++");
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}
		return root;
	}

	public Node lowestCAncestor(Node node, int a, int b) {
		if (node == null)
			return null;
		if (a > node.data && b > node.data) {
			lowestCAncestor(node.right, a, b);
		}
		if (a < node.data && b < node.data) {
			lowestCAncestor(node.left, a, b);
		}
		return node;
	}

	private static int kThCounter = 0;

	public Node kThSmallest(Node root, int k) {
		if (root == null)
			return null;
		Node left = kThSmallest(root.left, k);
		if (left != null) {
			return left;
		}

		if (++kThCounter == k) {
			return root;
		}
		return kThSmallest(root.right, k);
	}

	public boolean checkOneChildEach(Node root) {
		if (root == null) {
			return true;
		} else if (root.left != null && root.right != null) {
			return false;
		}

		boolean left = checkOneChildEach(root.left);

		if (left == false)
			return left;
		return checkOneChildEach(root.right);
	}

	public int getSize(Node root) {
		if (root == null) {
			return 0;
		}
		return getSize(root.left) + 1 + getSize(root.right);
	}

	public boolean checkIfCousin(Node root, int a, int b) {
		if (root == null) {
			return false;
		}
		Queue queue = new Queue();
		queue.enqueue(root);
		int[] treeElements = new int[getSize(root)];
		int counter = 0;
		while (queue.isEmpty() == false) {
			Node temp = queue.deQueue();
			treeElements[counter++] = temp.data;
			if (temp.left != null) {
				queue.enqueue(temp.left);
			}
			if (temp.right != null) {
				queue.enqueue(temp.right);
			}
		}

		String aPos = "";
		String bPos = "";
		int parentA = -999;
		int parentB = -999;

		// Find out the parent of a & b and check if a is left or right.
		for (int i = 0; i < treeElements.length / 2; i++) {
			int chkLeft = -999;
			int chkRight = -999;
			// Check so that we don't exceed the size limit
			try {
				chkLeft = treeElements[2 * i + 1];
				chkRight = treeElements[2 * i + 2];
			} catch (Exception e) {

			}

			if (chkLeft == a && chkLeft != -999) {
				parentA = i;
				aPos = "left";
			} else if (chkLeft == b && chkLeft != -999) {
				parentB = i;
				bPos = "left";
			}

			if (chkRight == a && chkLeft != -999) {
				parentA = i;
				aPos = "right";
			} else if (chkLeft == b && chkLeft != -999) {
				parentB = i;
				bPos = "right";
			}

		}

		// if any of them doesn't exist.
		if (parentA < 0 || parentB < 0)
			return false;
		else {
			// if parents are same they're not cousins
			if (parentA == parentB) {
				return false;
			} else {
				// if grad
				int grandParentA = -99;
				int grandParentB = -99;
				if (aPos == "left") {
					grandParentA = (parentA - 1) / 2;
				} else {
					grandParentA = (parentA - 2) / 2;
				}

				if (bPos == "left") {
					grandParentB = (parentA - 1) / 2;
				} else {
					grandParentB = (parentA - 2) / 2;
				}

				if (grandParentA == grandParentB)
					return true;
				else
					return false;
			}
		}

	}

	public void findMirror(Node root) {
		if (root == null) {
			return;
		}
		findMirror(root.left);
		findMirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public boolean checkCommon(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null) {
			return false;
		} else if (root1.data != root2.data) {
			return false;
		} else {
			return checkCommon(root1.left, root2.left) && checkCommon(root1.right, root2.right);
		}

	}

}
