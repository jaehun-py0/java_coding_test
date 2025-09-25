package Q5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws IOException{
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		//a, b 행렬
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] arr1 = new int[a][b]; 
		int[][] arr2 = new int[c][d]; 
		
		
		for (int i = 0; i < a; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < b; j++ ) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < c; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < d; j++ ) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(Arrays.deepToString(matrixMul(arr1, arr2)));
		
		
	}
	
	public static int[][] matrixMul(int[][] arr1, int[][] arr2){
		int r1 = arr1.length;
		int c1 = arr1[0].length;
		int r2 = arr2.length;
		int c2 = arr2[0].length;
		
		int[][] answer = new int[r1][c2];
		
		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c1; j++) {
				for (int k = 0; k < c2; k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		return answer;
	}
}
