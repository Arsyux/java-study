package chap12_enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Sample03_enum3 {

	public static void main(String[] args) {
		// 값을 갖는 열거형
		FLOWER1 f1 = FLOWER1.SUNFLOWER;
		System.out.println(f1.getName());
		
		FLOWER2 f2 = FLOWER2.ROSE;
		System.out.println(f2.getName());
	}

}

enum FLOWER1 {
	SUNFLOWER("sunflower"), ROSE("rose");

	private final String name;

	// 생성자가 private인 이유는 외부에서 열거형 상수의 임의 생성을 방지하고,
	// 열거형의 고정된 인스턴스를 유지하기 위해서임.
	private FLOWER1(String flowerName) {
		this.name = flowerName;
	}

	public String getName() {
		return this.name;
	}
}

// Lombok사용
@RequiredArgsConstructor
@Getter
enum FLOWER2 {
	SUNFLOWER("sunflower"), ROSE("rose");

	private final String name;

}