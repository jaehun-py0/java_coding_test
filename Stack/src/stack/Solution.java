package stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new ArrayDeque<>();
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		HashMap<Integer, String> hashmap = new HashMap<>();
		
		stack.add(3);
		stack.add(1);
		stack.add(5);
		stack.add(4);
		stack.add(7);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		deque.add(1);
		deque.add(2);
		deque.add(3);
		deque.add(4);
		deque.add(5);
		deque.add(6);
		
		for (int i = 0; i<3; i++) {
			System.out.println(deque.pollFirst());
		}
		for (int i = 0; i<3; i++) {
			System.out.println(deque.pollLast());
		}
		
		hashmap.put(1, "일");
		hashmap.put(2, "이");
		hashmap.put(3, "삼");
		hashmap.put(4, "사");
		
		System.out.println(hashmap.get(1));
		
		
	}
}
