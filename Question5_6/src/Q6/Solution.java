package Q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 전체 스테이지 개수
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 현재 사용자들이 멈춰있는 스테이지의 번호가 담긴 배열
		int[] stages = new int[st.countTokens()];
		
		for (int i = 0; i < stages.length; i++ ) {
			stages[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Arrays.toString(solution(N, stages)));
	}
	
	public static int[] solution(int N, int[] stages) {
		
		HashMap<Integer, Double> fails = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			final int level = i+1;
			long xclear = Arrays.stream(stages).filter(n -> n == level).count();
            long oclear = Arrays.stream(stages).filter(n -> n >= level).count();
            
            fails.put(level, oclear == 0 ? 0 : xclear/(double)oclear);
		}
		
		return fails.entrySet().stream().sorted((fail1, fail2) -> fail1.getValue().equals(fail2.getValue()) ? Integer.compare(fail1.getKey(), fail2.getKey()) : Double.compare(fail2.getValue(), fail1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
	}

}
