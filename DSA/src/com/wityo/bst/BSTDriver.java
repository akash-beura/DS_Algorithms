package com.wityo.bst;

public class BSTDriver {

	public static void main(String[] args) {
		BST bst = new BST();
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 6);
		bst.root = bst.insert(bst.root, 5);
		bst.root = bst.insert(bst.root, 8);
		bst.root = bst.insert(bst.root, 11);
		bst.root = bst.insert(bst.root, 12);
		
		BST bst2 = new BST();
		bst2.root = bst.insert(bst.root, 10);
		bst2.root = bst.insert(bst.root, 6);
		bst2.root = bst.insert(bst.root, 5);
		bst2.root = bst.insert(bst.root, 8);
		bst2.root = bst.insert(bst.root, 11);
		bst2.root = bst.insert(bst.root, 12);
		
		System.out.println(bst2.checkCommon(bst.root, bst2.root));;
	}
}


//		10
//	6		11
//5		8		12