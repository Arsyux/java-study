package chap09_Interface;

// UUID(범용 고유 식별자, universally unique identifier)
// 16옥텟(128비트)의 수로, 표준 형식에서 UUID는 32개의 16진수로 표현되며
// 총 36개 문자(32개 문자와 4개의 하이픈)로 된 8-4-4-4-12라는 5개의 그룹을 하이픈으로 구분함.
import java.util.UUID;

class LagacyUtil {
	
	public static String getRandom() {
		return (int) (Math.random() * 10 + 1) + "";
	}
	
}

// 상속의 활용
// -> 일반 클래스를 상속받아 재구현하기
class NewUtil extends LagacyUtil {

	// 변경된 부분만을 override하여 재구현
	// static선언이 되어있으므로 @Override 애너테이션을 사용할 수 없음.
	public static String getRandom() {
		return UUID.randomUUID() + "";
	}
	
}

public class Sample06_Extends {

	public static void main(String[] args) {
		String legacyKey = LagacyUtil.getRandom();
		System.out.println("레거시 키 값: " + legacyKey);

		for (int i = 0; i < 5; i++) {
			String key = NewUtil.getRandom();
			System.out.println("새로운 키 값: " + key);
		}
	}
}