package chap09_Interface;

import lombok.AllArgsConstructor;

// 프로그램을 함께 개발할 때 곡 구현해야 하는 메서드들을 미리 정해놓고 개발하는 경우가 있음.
// 일부 기능에서 차이가 있으면 일일이 다 구현하지 않고 한 번만 대표로 구현하고 나머지 차이가 있는 것은 그 부분만 다시 구현함.
// 이렇게 코드를 재사용 할 때는 추상 클래스나 인터페이스를 활용하여 구현함.

// 추상 클래스 (Abstract Class)
// 표준이 되는 클래스를 만들 때 바로 클래스를 만드는 것이 아니라 공통적인 멤버 변수와 멤버 메서드를 미리 구현해놓음.
// 특정 상태나 때에 따라 다른 내용을 구현해 놓을 경우 구현체가 없는 메서드만 선언해 놓은 메서드를 추상 메서드라고 함.
// 추상 메서드를 포함하는 클래스를 추상 클래스라고 함.
// 추상 메서드를 선언시 abstract 예약어를 붙힘.
// 실제로 구현하고자 하는 클래스는 추상 클래스를 상속받아서 추상 메서드를 오버라이팅 하여 재구현함.
// -> 추상 메서드는 구현체가 없기 때문
@AllArgsConstructor
abstract class Car {
	
	// protected를 적용하여 상속받는 자식 클래스에서도 접근할 수 있게 하였음.
	protected String color; // 색
	protected String manufacturer; // 제조사

	// 추상 메소드
	public abstract String fillUp(); // 휘발유, 듕유, 전기등을 넣음.

	public void printInfo() {
		System.out.println("색: " + color);
		System.out.println("충전 방식: " + fillUp());
		System.out.println("제조사: " + manufacturer);
	}

	public String getColor() {
		return this.color;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}
}

class ElecCar extends Car {

	public ElecCar(String color, String manufacturer) {
		super(color, manufacturer);
	}

	@Override
	public String fillUp() {
		return "전기";
	}

	// ElecCar에만 있는 메소드
	public void setColor(String color) {
		this.color = color;
	}
}

class GasolCar extends Car {

	public GasolCar(String color, String manufacturer) {
		super(color, manufacturer);
	}

	@Override
	public String fillUp() {
		return "휘발유";
	}
}

public class Sample01_AbstractClass {

	public static void main(String[] args) {
		ElecCar ec = new ElecCar("red", "현대");
		ec.setColor("white");
		ec.printInfo();
		Car c = new ElecCar("blue", "쌍용");
		// -> Car에 setColor가 없어서 사용 불가능
		// c.setColor("gray");
		c.printInfo();
		GasolCar gc = new GasolCar("black", "기아");
		gc.printInfo();
		
	}

}