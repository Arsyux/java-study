package chap12_enum;

import java.util.Arrays;
import java.util.EnumSet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Sample04_enum4 {

	public static void main(String[] args) {

		// 여러개의 값을 갖는 열거형
		// 하나의 상수명에 2개 이상의 값을 가질 수도 있음.
		// 상수 값이 늘어나면 멤버 변수를 늘려주면됨.
		
		// 열거형의 상수를 출력하는 법
		// 직접 입력 방식
		System.out.println("1. 동물원의 조류의 수");
		System.out.printf("%s, %d마리\n", BIRD.SPARROW.getName(), BIRD.SPARROW.getCount());
		System.out.printf("%s, %d마리\n", BIRD.PARROT.getName(), BIRD.PARROT.getCount());
		System.out.printf("%s, %d마리\n", BIRD.EAGLE.getName(), BIRD.EAGLE.getCount());
		System.out.printf("%s, %d마리\n", BIRD.FALCON.getName(), BIRD.FALCON.getCount());

		// 반복문을 통해 한번에 출력하기
		System.out.println("2. 동물원의 조류의 수");
		// EnumSet은 Set의 Enum 버전임.
		// Enumset<T>에 EnumSet.allOf(T.class)함수를 사용하여 할당한 후 향상된 for문으로 출력
		EnumSet<BIRD> birds = EnumSet.allOf(BIRD.class);
		for (BIRD b : birds) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}

		System.out.println("3. 동물원의 조류의 수");
		// 열거형.values() 함수를 통해 BIRD[] 배열을 반환하는것을 이용하여 for문으로 출력
		for (BIRD b : BIRD.values()) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}

		// CollectionFramwork에서 배운 forEach를 사용하여 출력
		System.out.println("4. 동물원의 조류의 수");
		Arrays.asList(BIRD.values()).forEach(BIRD -> System.out.printf("%s, %d마리\n", BIRD.getName(), BIRD.getCount()));
		
		System.out.println("4. 독수리 삭제");
		birds.remove(BIRD.EAGLE);
		for (BIRD b : birds) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}
		
		System.out.println("5. 독수리 추가");
		birds.add(BIRD.EAGLE);
		for (BIRD b : birds) {
			System.out.printf("%s, %d마리\n", b.getName(), b.getCount());
		}
	}

}

@RequiredArgsConstructor
@Getter
enum BIRD {
	SPARROW("참새", 33), PARROT("앵무새", 27), EAGLE("독수리", 2), FALCON("매", 8);

	// 값이 3개면 늘리면됨.
	private final String name;
	private final int count;
}