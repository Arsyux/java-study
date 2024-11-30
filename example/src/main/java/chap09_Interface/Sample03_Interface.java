package chap09_Interface;

// 인터페이스와 추상 클래스와의 차이점
// -> 추상클래스는 구현체가 있는 메서드는 상속받게 되는 객체에서 모두 사용할 수 있고 추상 메서드만 새로 재정의해서 사용하면 됨.
// -> 반면 인터페이스는 추상 메서드만 존재하게됨.

// JDK 1.8 부터 디폴트 메서드(Default Method)가 추가되었음.
// 디폴트 메서드는 추상 클래스에서 공통으로 사용하는 일반 메서드임.
// 인터페이스를 만들어놓고 수많은 클래스에서 이 인터페이스를 참조하여 메서드를 재정의 하였는데,
// 추후 메서드를 추가해야하는 경우가 발생했을 때 사용함.

// 디폴트 메서드의 특징
// Implements한 클래스에서 구현하지 않아도 됨.
// 마치 추상 클래스에서 정의한 일반 메서드와 똑같은 결과를 얻을 수 있음.
// 디폴트 메서드의 default는 접근제어자가 아님.

// abstract는 생략 가능
abstract interface ICompute {
	
	// 인터페이스의 멤버 변수는 'static final'로 컴파일 됨.
	// 즉, 값의 변경이 불가능
	float pyung = 3.3f;

	// abstract float compute(int area); 추상 메서드로 처리됨.
	float compute(int area);

	// 새로운 메서드 추가. implements된 모든 클래스는 이 메서드를 구현해야함.
	float toPyung(int area);
}

class Apartment implements ICompute {

	@Override
	public float compute(int area) {
		return area * pyung;
	}

	@Override
	public float toPyung(int area) {
		return area / pyung;
	}
}

interface IExcute {
	float pyung = 3.3f;

	float compute(int area);

	// 디폴트 메서드
	// 접근 제어자가 생략되어있음.
	// 즉 (default) default float toPyung(float area) { ... }임.
	default float toPyung(float area) {
		return area / pyung;
	}

}

class Villa implements IExcute {

	@Override
	public float compute(int area) {
		return area * pyung;
	}
}

public class Sample03_Interface {

	public static void main(String[] args) {
		ICompute a = new Apartment();
		float area = a.compute(30);
		System.out.println(area);
		float pyung = a.toPyung(99);
		System.out.println(pyung);
	}
}