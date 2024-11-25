package chap02_Type;

import java.util.Scanner;

public class Sample04_Scanner {

	public static void main(String[] args) {
		// Scanner
		// 자료형별로 값을 구해오는 메서드들
		// next(): 공백 이전까지 문자열을 반환
		// nextByte(): 공백 이전까지의 byte형을 반환
		// nextShort(): 공백 이전까지의 short형을 반환
		// nextInt(): 공백 이전까지의 int형을 반환
		// nextLong(): 공백 이전까지의 long형을 반환
		// nextFloat(): 공백 이전까지의 float형을 반환
		// nextDouble(): 공백 이전까지의 double형을 반환
		// nextLine(): 입력 받은 문자열 전체 입력을 반환
		// hasNextInt(): 다음 가져올 자료형이 int형인지 확인하고 맞으면 true, 틀리면 false를 반환
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력해주세요.");
		if (sc.hasNextDouble()) {
			System.out.println("입력하신 문자는 숫자입니다. ");
		} else {
			System.out.println("입력하신 문자는 숫자가 아닙니다.");
		}
		sc.close();
	}
}