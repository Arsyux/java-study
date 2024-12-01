package chap10_Generic;

public class Sample05_LimitedGenericMethod1 {

	public static void main(String[] args) {
		Data d = new Data();
		d.setValue(3);
		System.out.println(d.getValue());
	}
}

class Data {
	String value;
	
	// 제네릭 메서드
	// 클래스에서 제네릭 타입을 정의하면 객체를 생성할 때 어떠한 자료형이 들어간다고 정의하지만
	// 메서드나 생성자에 제네릭 타입을 정의하면 따로 정의하지 않고 내부에서 처리함.
	public <T> void setValue(T t) {
		this.value = t.toString();
	}
	
	public String getValue() {
		return this.value;
	}
}