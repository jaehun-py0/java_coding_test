package set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException{
		StringTokenizer st = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int	k = Integer.parseInt(st.nextToken()); // 노드 수
		int	n = Integer.parseInt(st.nextToken()); // oper 수
		
		
		int[][] operations = new int[k][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			operations[i][0] = Integer.parseInt(st.nextToken());
			operations[i][1] = Integer.parseInt(st.nextToken());
			operations[i][2] = Integer.parseInt(st.nextToken());
		}
		
		solution(k, operations);
	}
	
	static void solution(int k, int[][] operations) {
		
		int[] parent = new int[k+1];
		for (int i = 1; i < k+1; i++) parent[i] = i;
		
		for(int i = 0; i < operations.length; i++) {
			if (operations[i][0] == 0) union(parent, operations[i][1], operations[i][2]);
			if (operations[i][0] == 1) find(parent, operations[i][1], operations[i][2]);
		}
		
	}
	
	static void union(int[] parent, int node1, int node2) {
		// 단순 합치기
		int root1 = find_root(parent, node1);
		int root2 = find_root(parent, node2);
		parent[root2] = root1;
	}
	
	static void find(int[] parent, int node1, int node2) {
		// 같다면 return 한다 뭘로? 루트로
		if (find_root(parent, node1) == find_root(parent, node2)) {
			System.out.println("TRUE");
		}
		else {
			System.out.println("FALSE");
		}
	}
	
	static int find_root(int[] parent, int node) {
		if (parent[node] == node) {
			return node;
		}
		
		parent[node] = find_root(parent, parent[node]);
		return parent[node];
	}
	

}
