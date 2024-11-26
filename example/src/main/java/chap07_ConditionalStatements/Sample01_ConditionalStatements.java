package chap07_ConditionalStatements;

public class Sample01_ConditionalStatements {

	public static void main(String[] args) {
		// 조건문
		int num = 5;
		if (num <= 10) {
			System.out.println("num이 10이하입니다.");
		} else if (num > 10 && num < 20) {
			System.out.println("num이 10초과 20미만입니다.");
		} else {
			System.out.println("num이 20이상입니다.");
		}
		
		// switch ~ case
		switch (num) {
		case 5:
			System.out.println("num은 5입니다.");
			break;
		default:
			System.out.println("num은 5가 아닙니다.");
			break;
		}
		
		// (Java14) multi-label case
		int in = 6;
		switch (in) {
		case 1, 3, 5, 7, 9:
			System.out.println("in은 홀수 입니다.");
			break;
		case 2, 4, 6, 8, 10:
			System.out.println("in은 짝수 입니다.");
			break;
		default:
			System.out.println("in은 1~10사이의 수가 아닙니다.");
			break;
		}

		// (Java14) 향상된 switch ~ case
		// 향상된 switch문 사용법1
		in = 71;
		switch(in) {
			case 1, 3, 5, 7, 9 -> System.out.println("홀수 입니다.");
			case 2, 4, 6, 8, 10 -> System.out.println("짝수 입니다.");
			default -> {
				System.out.println("1~10사이의 수가 아닙니다.");
				System.out.println("정확한 숫자를 입력해주세요.");
			}
		}
		
		// 향상된 switch문 사용법2
		in = 1;
		String season = switch(in) {
			case 12, 1, 2 -> "겨울";
			case 3, 4, 5 -> "봄";
			case 6, 7, 8 -> "여름";
			case 9, 10, 11 -> "가을";
			default -> "에러";
		}; // switch문으로 값을 반환할 경우 중괄호 끝에 세미콜론 필요
		System.out.println("계절: " + season);
		
		
		// (JDK13이상) 향상된 switch문 사용법3
		// (JDK12) JDK13이전에는 yield가 아니라 break를 사용하여 값을 반환함.
		in = 6;
		season = switch(in) {
			case 12, 1, 2: yield "겨울";
			//(JDK12)case 12, 1, 2: break "겨울";
			case 3, 4, 5: yield "봄";
			case 6, 7, 8: yield "여름";
			case 9, 10, 11: yield "가을";
			default: yield "에러";
		};
		System.out.println("계절: " + season);
	}
}