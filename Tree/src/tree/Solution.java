package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nodes = new int[st.countTokens()];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		
		long start1 = System.currentTimeMillis();
		solution_Arrays(nodes);
		long end1 = System.currentTimeMillis();
		System.out.println("---------");
		long start2 = System.currentTimeMillis();
		solution_Nodes(nodes);
		long end2 = System.currentTimeMillis();
		
		System.out.println(end1 - start1);
		System.out.println(end2 - start2);
		
	}
	
	// Using Arrays
	public static void solution_Arrays(int[] nodes) {
		StringBuilder sb = new StringBuilder();
		preorder(nodes, 0, sb);
		System.out.println(sb);
		
		sb = new StringBuilder();
		inorder(nodes, 0, sb);
		System.out.println(sb);
		
		sb = new StringBuilder();
		postorder(nodes, 0, sb);
		System.out.println(sb);
	}
	
	public static void preorder(int[] nodes, int idx, StringBuilder sb) {
		if (idx >= nodes.length) return;
		
		sb.append(nodes[idx]).append(" ");
		preorder(nodes, idx*2+1, sb);
		preorder(nodes, idx*2+2, sb);
		return ;
	}
	
	public static void inorder(int[] nodes, int idx, StringBuilder sb) {
		if (idx >= nodes.length) return;
		
		inorder(nodes, idx*2+1, sb);
		sb.append(nodes[idx]).append(" ");
		inorder(nodes, idx*2+2, sb);
		return ;
	}

	public static void postorder(int[] nodes, int idx, StringBuilder sb) {
		if (idx >= nodes.length) return;
		
		postorder(nodes, idx*2+1, sb);
		sb.append(nodes[idx]).append(" ");
		postorder(nodes, idx*2+2, sb);
		return ;
	}
	
	static class Node{
		int data;
		Node left_node;
		Node right_node;
		
		Node(int data) {
			this.data = data;
			this.left_node = null;
			this.right_node = null;
		}
	}
	
	static void solution_Nodes(int[] nodes) {
		Node root = buildTree(nodes, 0);
		
		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		System.out.println(sb);
		
		sb = new StringBuilder();
		inorder(root, sb);
		System.out.println(sb);
		
		sb = new StringBuilder();
		postorder(root, sb);
		System.out.println(sb);
		
		
	}
	
	static Node buildTree(int[] nodes, int i) {
		if (i >= nodes.length) return null;
		Node node = new Node(nodes[i]);
		node.left_node = buildTree(nodes, i*2+1);
		node.right_node = buildTree(nodes, i*2+2);
		return node;
	}
	
	static void preorder(Node node, StringBuilder sb) {
		if (node == null) return;
		sb.append(node.data).append(" ");
		preorder(node.left_node, sb);
		preorder(node.right_node, sb);
		return;
	}
	
	static void inorder(Node node, StringBuilder sb) {
		if (node == null) return;
		inorder(node.left_node, sb);
		sb.append(node.data).append(" ");
		inorder(node.right_node, sb);
		return;
	}
	
	static void postorder(Node node, StringBuilder sb) {
		if (node == null) return;
		postorder(node.left_node, sb);
		postorder(node.right_node, sb);
		sb.append(node.data).append(" ");
		return;
	}
	
	
}
