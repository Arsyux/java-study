package chap02_Type;

public class Sample05_var {

	public static void main(String[] args) {
		// var : 지역 변수의 타입 추론 (Local variable type inference)
		// Java 10부터 사용 가능하므로 사용하기전에 java 버전이 10이상인지 확인하고 구현할 것.
		var v1 = "Age : ";
		var v2 = 30;
		System.out.println(v1 + v2);

		// null사용 불가, 선언시 값을 넣어주어야함.
		// v3의 자료형을 추론할 수 없어서 [Cannot use 'var' on variable without initializer]에러 발생
		//var v3;
		
		// 상수 (const)
		// 상수는 값 변경이 불가능함.
		// final [자료형] [변수명] = [리터럴];
		final String s = "Age : ";
		final int f = 31;
		System.out.println(s + f);
		// 계산에는 사용가능함.
		System.out.println(v2 + f);
	}
}