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
		System.out.println(Arrays.toString(solution2(N, stages)));
	}
	
	public static int[] solution(int N, int[] stages) {
		
		HashMap<Integer, Double> fails = new HashMap<>();
		
		// 시간 복잡도 N
		for (int i = 0; i < N; i++) {
			final int level = i+1;
			
			// 시간 복잡도 M
			long xclear = Arrays.stream(stages).filter(n -> n == level).count();
            long oclear = Arrays.stream(stages).filter(n -> n >= level).count();
            
            fails.put(level, oclear == 0 ? 0 : xclear/(double)oclear);
		}
		
		// -> N.M
		
		
		// 시간 복잡도 NlogN
		return fails.entrySet().stream().sorted((fail1, fail2) -> fail1.getValue().equals(fail2.getValue()) ? Integer.compare(fail1.getKey(), fail2.getKey()) : Double.compare(fail2.getValue(), fail1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
		
		// Total N*M + NlogN
	}
	
	public static int[] solution2(int N, int[] stages) {
		int M = stages.length;
		
		// 스테이지별 멈춰있는 사람들의 수 -> M
		int[] stays = new int[N+2];
		for(int i : stages) {
			if(i < N+2) stays[i]++;
		}
		
		// 클리어 한 사람들의 수 -> M
		int[] clears = new int[N+2];
		for (int i = N; i >= 1; i--) {
			clears[i] = clears[i+1] + stays[i]; 
		}
		
		HashMap<Integer, Double> fails = new HashMap<>();
		for(int i = 1; i < N+1; i++) {
			fails.put(i, clears[i] == 0 ? 0 : stays[i]/(double)clears[i]);
		}
		
		System.out.println(fails);
		System.out.println(Arrays.toString(stays));
		System.out.println(Arrays.toString(clears));
		
		return fails.entrySet().stream().sorted((fail1, fail2) -> fail1.getValue().equals(fail2.getValue()) ? Integer.compare(fail1.getKey(), fail2.getKey()) : Double.compare(fail2.getValue(), fail1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
	}

}
