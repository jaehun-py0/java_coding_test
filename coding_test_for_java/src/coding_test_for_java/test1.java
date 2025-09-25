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
		
//		int[] student1 = new int[] {1, 2, 3, 4, 5};
//		int[] student2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
//		int[] student3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[][] pattern = {
				{1,2,3,4,5},
				{2,1,2,3,2,4,2,5},
				{3,3,1,1,2,2,4,4,5,5}
		};
		
//		int[][] score = new int[3][];
		int[] score = new int[3];
		
		for (int i = 0; i < arr.length; i ++) {
			for (int j = 0; j < pattern.length; j++) {
				if (arr[i] == pattern[j][i%pattern[j].length]) {
					score[j]++;
				}
			}
		}
		
		// 가장 높은 점수 저장
		int max_score = Arrays.stream(score).max().getAsInt();
		
		ArrayList<Integer> answer = new ArrayList<>();
		
 		// 가장 높은 점수를 가진 수포자들 번호를 찾아 리스트 담음
		for (int i = 0; i < score.length; i++) {
			if (score[i] == max_score) {
				answer.add(i+1);
			}
		}
		System.out.println(Arrays.toString(answer.stream().mapToInt(Integer::intValue).toArray()));
		// answer는 Integer 객체스트림이므로, mapToInt를 통해 int 기본형 스트림으로 변환한 뒤 배열로 반환한다.
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
