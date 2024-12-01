package chap11_CollectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sample09_HashMap1 {

	public static void main(String[] args) {
		// HashMap
		// => Key, Value로 이루어진 자료형
		// 내부적으로 해싱(hash) 메커니즘을 사용하여 데이터를 저장하므로, 삽입 및 검색 성능이 매우 뛰어남
		// 삽입 순서를 보장하지않음. 데이터는 해시값에 따라 저장되므로 출력 순서는 불확실함.
		// 장점
		// 빠른 데이터 검색, 삽입, 삭제
		// 대량의 데이터를 다룰 때 유용함
		// 단점
		// 해싱때문에 메모리를 더 많이 사용할 수 있음
		// 동기화되지 않음 => 멀티 스레드 환경에서는 ConcurrentHashMap사용을 권장
		
		// clear()
		// clone()
		// put() - 키와 값을 맵에 추가
		// putAll()
		// compute() - 지정된 키에 매핑된 정보를 처리. 없을 경우 예외 발생
		// computeIfAbsent() - 지정된 키가 Map에 존재하지 않는다면 키를 추가하고 매핑 함수의 결과가 값에 반영됨
		// computeIfPresent() - 지정된 키가 존재할 경우에 매핑된 정보를 처리
		// containsKey() - 맵에 지정된 키가 포함되어 있는지 여부를 반환
		// containsValue() - 맵에 지정된 값이 포함되어 있는지 여부를 반환
		// entrySet() - Map의 key=value 형태의 Set으로 반환
		// get()
		// isEmpty()
		// keySet() - Map의 키를 Set의 형태로 반환
		// marge() - 키 값이 존재하면 이전 값과 지정한 값을 인자로 함수 결과를 반환
		// remove()
		// size()
		// values() - 맵의 모든 값을 Collection으로 반환
		var map = new HashMap<String, Integer>();
		map.put("Java", 1);
		map.put("C", 2);
		map.put("C++", 3);
		map.put("C#", 4);
		map.put("Python", 5);
		map.put("JS", 6);
		map.put("PHP", 7);
		map.put("VB", 8);
		map.put("Perl", 9);
		map.put("Delphi", 10);

		@SuppressWarnings("unchecked")
		Map<String, Integer> beforeMap = (Map<String, Integer>) map.clone();
		Set<String> keys = map.keySet();

		// 향상된 for문
		System.out.println("==Enhanced for Loop");
		for (String key : keys) {
			System.out.println(key);
		}
		
		// 람다식
		System.out.println("==Lambda expression");
		keys.forEach((s) -> System.out.println(s));

		// 메서드 참조
		System.out.println("==Method references");
		map.keySet().forEach(System.out::println);

		System.out.println(map.toString());

		// 총 맵의 매핑 수
		System.out.println("size() : " + map.size());

		// Ruby가 10위로 들어오고 Delphi가 10권 밖으로 사라짐
		if (map.containsKey("Delphi")) {
			map.remove("Delphi");
			map.put("Ruby", 10);
		} else {
			System.out.println("Delphi가 없습니다.");
		}
		System.out.println(map);

		// Java가 순위에서 1계단 내려오고 C가 한계단 올라감
		// computeIfPresent() 메서드는 키가 존재하면 조회된 키와 값을 인자로 함수의 결과를 값에 반영함
		// 키가 "Java"인 값을 전위 증감 연산자로 1올렸음.
		map.computeIfPresent("Java", (String key, Integer value) -> ++value);
		System.out.println(map);
		// 키가 "C"인 값을 전위 증감 연산자를 사용해 1내렸음.
		map.computeIfPresent("C", (String key, Integer value) -> --value);
		System.out.println(map);

		System.out.println("Before: " + beforeMap);
		System.out.println("After: " + map);
	}

}