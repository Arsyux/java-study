package chap16_LambdaExpression;

public class Sample01_Lambda1 {

	public static void main(String[] args) {
		
		Sample01Function f1 = () -> System.out.println("람다 출력");
		f1.test();
		
		Sample02Function f2 = new Sample02Function() {
			@Override
			public void test(String name) { 
				System.out.println("Hello, " + name +"!");
			}
		}; 
		f2.test("A");
		
		Sample02Function f3 = (n) -> System.out.println("Hello, " + n + "!");
		f3.test("B");
		
		Runnable r = () -> System.out.println("익명 내부 클래스를 람다식으로 실행");
		r.run();
		
	}
	
}

// @FunctionalInterface
// 하나의 추상 메서드만을 가지는 인터페이스를 명시적으로 표시함
@FunctionalInterface
interface Sample01Function {
	public abstract void test(); // 한개의 추상 메서드
}

@FunctionalInterface
interface Sample02Function {
	public abstract void test(String name);
}