package chap06_Loop;

public class Sample01_Loop {

	public static void main(String[] args) {
		
		var Hello = "HelloWorld!";
		// toCharArray() 함수를 사용해 char배열 을 생성
		char[] chr = Hello.toCharArray();

		System.out.println("for문");
		for (int i = 0; i < chr.length; i++) {
			System.out.print(chr[i] + " ");
		}
		System.out.println();
		System.out.println();

		System.out.println("다중 for문 - 구구단");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
			}
			System.out.println();
		}
		
		// 향상된 for문
		System.out.println("향상된 for문");
		for (char c : chr) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.println();
		
		// While
		System.out.println("while문");
		int idx = 0;
		while(idx < Hello.length()) {
			System.out.print(chr[idx] + " ");
			idx++;
		}
		System.out.println();
		System.out.println();
		
		// do ~ while문
		System.out.println("do ~ while문");
		idx = 0;
		do {
			System.out.print(chr[idx] + " ");
			idx++;
		} while((idx < Hello.length()));
		
	}
}