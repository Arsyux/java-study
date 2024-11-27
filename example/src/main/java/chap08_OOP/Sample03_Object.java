package chap08_OOP;

// Object는 모든 클래스의 최상위 클래스로 배열을 포함한 모든 객체는
// 이 Object 클래스의 메서드를 구현함.
// -> class를 구현하면 자동으로 Object를 상속받음.(extends Object가 생략되어있음.)
class Sample03_1 /*extends Object*/ {
	
	String name;
	
	public Sample03_1(String name) {
		this.name = name;
	}

}

class Sample03_2 {
	
	String name;
	
	public Sample03_2(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Sample03_2 [name=" + name + "]";
	}
}

public class Sample03_Object {

	public static void main(String[] args) {

		String s1 = "s";
		String s2 = "s";
		String s3 = new String("s");

		// Object.equals()
		// 두 객체를 비교하여 같으면 true, 다르면 false를 반환함.
		// ==는 객체가 같은지를 비교하고 equals() 는 객체의 값을 비교함.
		System.out.println("s1 == s2: " + (s1 == s2));
		System.out.println("s1 == s3: " + (s1 == s3));
		System.out.println("s1.equals(s2): " + s1.equals(s2));
		System.out.println("s1.equals(s3): " + s1.equals(s3));
		
		// Object.toString()
		// toString()을 호출하면 클래스명과 객체 해시 코드의 부호 없는 16진수 값과 함께 '@'로 구분하여 문자열을 반환함.
		// 그래서 상속받은 toString() 메서드를 재정의(Overriding)하여 객체의 내용을 출력해서 확인함.
		Sample03_1 s31 = new Sample03_1("s31");
		Sample03_2 s32 = new Sample03_2("s32");
		System.out.println(s31.toString());
		System.out.println(s32.toString());
		
	}
	
}
