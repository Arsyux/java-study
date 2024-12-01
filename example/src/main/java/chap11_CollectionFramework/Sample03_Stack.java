package chap11_CollectionFramework;

import java.util.Stack;

public class Sample03_Stack {

	public static void main(String[] args) {
		var stack = new Stack<Integer>();

		// 스택은 후입선출(LIFO, Last In First Out)임.
		// 즉 1, 2, 3으로 넣었을 경우
		//
		// │       3       │
		// │       2       │
		// │       1       │
		// └───────────────┘
		// 
		// 형태로 되어있으며 pop()함수를 이용하여 요소를 반환하면
		// 3, 2, 1 순으로 빠져나감
		stack.add(1);
		stack.add(2);
		stack.add(3);
		
		System.out.printf("Size() : %d\n", stack.size());
		
		while(!stack.isEmpty()) {
			// 객체를 반환만하고 제거하지 않길 원한다면
			//stack.peek();
			System.out.println(stack.pop());
		}
		
		System.out.printf("Size() : %d\n", stack.size());
		
		// 예시로 뒤로가기를 들 수 있음.
		System.out.println("뒤로가기 예시");
		
		Stack<String> back = new Stack<String>();
		back.add("naver");
		back.add("google");
		back.add("github");
		
		while(!back.isEmpty()) {
			System.out.println(back.pop());
		}
	}

}