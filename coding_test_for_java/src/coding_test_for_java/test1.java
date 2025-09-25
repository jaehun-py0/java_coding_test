package coding_test_for_java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class test1 {
	static public void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
 		solution(arr);
		
		
	}
	
	static public int[] solution(int[] arr) {
		
		int[] student1 = new int[] {1, 2, 3, 4, 5};
		int[] student2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[][] score = new int[3][];
		
		score[0] = new int[] {1, 0};
		score[1] = new int[] {2, 0};
		score[2] = new int[] {3, 0};
		
		for (int i = 0; i < arr.length; i ++) {
			if (arr[i] == student1[i%student1.length]) { score[0][1] += 1;}
			if (arr[i] == student2[i%student2.length]) { score[1][1] += 1;}
			if (arr[i] == student3[i%student3.length]) { score[2][1] += 1;}
		}
		
		Arrays.sort(score, (arr1, arr2) -> Integer.compare(arr2[1], arr1[1]));
		int max_score = score[0][1];
		
		ArrayList<Integer> gp = new ArrayList<>();
		for (int i = 0; i < score.length; i++) {
			if (score[i][1] == max_score) {
				gp.add(score[i][0]);
			}
		}
		
		int[] result = gp.stream().mapToInt(Integer::intValue).toArray();
		
		return result;
	}
}
