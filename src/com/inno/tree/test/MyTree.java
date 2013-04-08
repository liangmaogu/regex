package com.inno.tree.test;

import java.util.ArrayList;
import java.util.List;

public class MyTree<T> {
	private TreeNode root;
	
	class TreeNode {
		T data;
		List<TreeNode> children;
	}
	
	public MyTree(T data) {
		root = new TreeNode();
		root.data = data;
		root.children = new ArrayList<MyTree<T>.TreeNode>();
	}
	
	public void insert(T data) {
		TreeNode node = new TreeNode();
		node.data = data;
		node.children = new ArrayList<MyTree<T>.TreeNode>();
		root.children.add(node);
	}
	
	public static void main(String[] args) { 
		MyTree<String> tree  = new MyTree<String>("hello");
		tree.insert("dasf");
	}
}
