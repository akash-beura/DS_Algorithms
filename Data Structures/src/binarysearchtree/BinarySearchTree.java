package binarysearchtree;

public class BinarySearchTree {

	Node root;

	public Node createNewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		return temp;
	}

	public Node insertNode(int data, Node root) {
		if (root == null) {
			root = createNewNode(data);
			return root;
		}
		if (data <= root.data) {
			root.left = insertNode(data, root.left);
		}
		if (data > root.data) {
			root.right = insertNode(data, root.right);
		}
		return root;
	}

	public void search(Node root, int data) {
		if (root == null) {
			System.out.println("Data not found");
			return;
		}
			
		if (root.data == data) {
			System.out.println("Data found!!");
		} else if (data < root.data) {
			search(root.left, data);
		} else if (data > root.data)
			search(root.right, data);
	}
	
	public void levelOrderTraversal(Node root) {
		if(root == null)
			return;
		Queue q = new Queue();
		q.enQueue(root);
		System.out.println("LEVEL ORDER TRAVERSAL:");
		while(q.getFront()!=null) {
			Node temp = q.getFront();
			System.out.print(temp.data+" ");
			if(temp.left != null)
				q.enQueue(temp.left);
			if(temp.right != null)
				q.enQueue(temp.right);
			q.deQueue();
		}
	}
	
	public void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data+" ");
		if(root.left !=null)
			preOrder(root.left);
		if(root.right !=null)
			preOrder(root.right);
	}
	
	public void inOrder(Node root) {
		if(root == null) {
			return;
		}
		if(root.left !=null)
			inOrder(root.left);
		System.out.println(root.data+" ");
		if(root.right !=null)
			inOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if(root == null) {
			return;
		}
		if(root.left !=null)
			postOrder(root.left);
		if(root.right !=null)
			postOrder(root.right);
		System.out.println(root.data+" ");
	}
	
	Node findMinimum(Node root) {
		if(root == null)
			return root;
		else {
			Node temp = root;
			while(temp.left!=null) {
				temp=temp.left;
			}
			return temp;
		}
	}
	
	Node findMaximum(Node root) {
		if(root == null)
			return root;
		else {
			Node temp = root;
			while(temp.right!=null) {
				temp=temp.right;
			}
			return temp;
		}
	}
	
	public Node delete(Node root, int data) {
		if(root == null)
			root = null;
		else if(data < root.data) {
			root.left = delete(root.left, data);
		} else if(data > root.data) {
			root.right = delete(root.right, data);
		}
		else {
			if(root.left == null && root.right == null) {
				return root;
			}
			else if(root.left == null) {
				root = root.right;
			}
			else if(root.right == null) {
				root = root.left;
			} else {
				Node temp = findMinimum(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);
			}
		}
		return root;
	}

}
