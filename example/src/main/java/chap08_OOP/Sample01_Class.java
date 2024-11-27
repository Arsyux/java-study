// 패키지
// 패키지는 Java파일의 디렉터리 경로를 표시하는 방법임.
package chap08_OOP;

// 클래스
// 클래스는 특정 객체를 생성하기 위해 변수와 메소드를 정의하는 틀임.
class ClassVO {
		
	/* 필드 영역 시작 */
	// 필드는 클래스 내에 위치하며 기본 자료형 변수나 비기본 자료형 변수가 멤버 변수가 됩니다.
	
	// 클래스 변수: 클래스를 생성하지 않고 바로 사용할 수 있는 변수
	// 인스턴스 변수: new 키워드를 사용해서 인스턴스를 생성한 뒤에 사용할 수 있는 변수
	
	// 클래스 변수는 변수 앞에 static을 붙이면 됨.
	static final int ONE;
	static final int TWO;
	static final int THREE;
	
	// static block
	// static 변수의 값을 정의하지 않고 static block을 사용하여 초깃값을 정의할 수 있음.
	// static block 클래스가 메모리에 올라가면서 호출되기 때문에 생성자보다 먼저 실행됨.
	static {
		System.out.println("static block 호출");
		ONE = 1;
		TWO = 2;
		THREE = 3;
	}
	
	// 인스턴스 변수는 인스턴스를 생성한 뒤에 사용할 수 있음.
	String name;
	int age;
	/* 필드 영역 끝*/

	
	/* 메서드 영역 시작 */
	// 메서드는 다른 언어에서는 함수(function)으로 표현됨.
	// 함수는 독립적으로 사용할 수 있지만 메서드는 클래스에 종속되어 사용되므로 함수보다는 작은 개념으로 사용됨.
	// 주로 동사형으로 작성함.
	
	// 접근 제어자
	// public - public으로 선언된 클래스, 변수, 메소드는 다른 패키지에서도 자유롭게 접근할 수 있음.
	// protected - protected로 선언된 변수나 메소드는 같은 패키지 내 또는 상속을 받은 자식 클래스에서 접근할 수 있음.
	// default(접근 제어자를 생략한 경우) - 같은 패키지 내에서만 접근할 수 있음.
	// private - private으로 선언된 변수나 메소드는 해당 클래스 내에서만 접근할 수 있고, 외부에서는 접근할 수 없음.

	// 메서드에서의 변수
	// 인자(Argument): 메서드를 호출할 때 전달하는 변수
	// 매개변수(Parameter): 메서드에서 전달받은 변수
	// 지역 변수(Local variable): 메서드 내의 변수
	
	// Setter
	public void setAge(int age) {
		// 매개변수와 멤버 변수명이 동일할 경우 매개변수가 우선순위가 됨.
		// 따라서 56줄의 코드는 매개변수 값에 매개변수를 넣기 때문에 변숫값에 대한 할당은 영향을 미치지 않음.
		//age = age;
		// 멤버 변수 age에 매개변수 age를 넣기위해 구분해준는 키워드가 바로 this임.
		// this: 인스턴스 자신을 가리키는 참조 변수이며 생성자나 메서드에서 사용되고 멤버 변수를 선택할 때 주로 사용함.
		// 특히 매개변수와 변수명이 동일할 경우 구별할 목적으로 사용됨.
		this.age = age;
	}

	// Getter
	public int getAge() {
		return age;
	}

	public void Hello() {
		System.out.println("Hello, World!");
	}

	// Overloading
	// 오버로딩: 메서드명은 같으나 매개변수의 자료형이나 그 수를 다르게 구성하여 다양한 유형을 처리하기위한 기술
	public void Hello(String name) {
		System.out.println("Hello, " + name);
	}

	// 가변인자
	// 가변인자는 다음과 같이 메서드안에 몇 개의 인자가 올지 알 수 없는 상황에 사용함.
	public int sum(int... a) {
		int total = 0;
		for (int i : a) {
			total += i;
		}
		return total;
	}
	
	// 일반 인자들과 함께 가변 인자를 사용할 경우에는
	// 가변인자가 맨 마지막에 들어가야하며, 가변 인자는 한 개만 들어갈 수 있음.
	public int test(int mul, int... number) {
		return mul * sum(number);
	}

	// 재귀함수(RecursiveFunction)
	// 메서드 내에서 스스로를 반복적으로 호출하여 처리하는 방식
	public int factorial(int number) {
		if(number == 1) { return 1; }
		return number * factorial(number - 1);
	}
	
	public String toString() {
		return "ClassVO [name=" + name + ", age=" + age + "]";
	}
	/* 메서드 영역 끝*/

	/* 생성자 영역 시작 */
	// 생성자(Constructor)
	// 생성자는 new 키워드와 함께 사용하여 객체를 생성함.
	
	// 생성자와 메서드의 차이
	// 1. 반환값(return)이 없다.
	// 2. 생성자명은 클래스명과 같다.
	// 3. 1개의 클래스는 1개 이상의 생성자를 가질 수 있다.
	
	// 생성자는 구현하지 않아도 내부적으로 존재함.
	// 따라서 의미 없는 생성자는 굳이 만들 필요가 없음.
	public ClassVO() { System.out.println("생성자 호출"); }
	public ClassVO(String name, int age) {
		System.out.println("생성자 호출");
		this.name = name;
		this.age = age;
	}
	/*생성자 영역 끝*/
}



public class Sample01_Class {

	public static void main(String[] args) {
		ClassVO cv = new ClassVO();
		cv.setAge(20);
		System.out.println(cv.getAge() + ClassVO.ONE);
		cv.Hello("World!");
		System.out.println(cv.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println("4!: " + cv.factorial(4));
		System.out.println(cv.toString());
	}
}