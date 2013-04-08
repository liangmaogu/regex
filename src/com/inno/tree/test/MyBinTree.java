package com.inno.tree.test;

import java.util.Random;

public class MyBinTree<T> {
	class TreeNode {
		T data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	private TreeNode root;
	
	public MyBinTree() {
		root = null;
	}
	
	public void insert(T data) {
		root = insert(root, data);
	}
	
	private TreeNode insert(TreeNode node, T data) {
		if (node == null) {
			node = new TreeNode(data);
		} else {
			if (data.hashCode() <= node.data.hashCode()) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		
		return node;
	}
	
	public void printTree() {
		printTree(root);
		System.out.println();
	}
	
	public void printTree(TreeNode node) {
		if (node == null) {
			return;
		}
		printTree(node.right);
		System.out.println(node.data + " ");
		printTree(node.left);	
	}
	
	public static void main(String[] args) {
		MyBinTree<Integer> tree = new MyBinTree<Integer>();
		
		for (int i = 0; i < 100; i++) {
			tree.insert(new Random().nextInt());
		}
		
		tree.printTree();
	}
}
