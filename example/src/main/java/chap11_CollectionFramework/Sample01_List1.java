package chap11_CollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class Sample01_List1 {

	public static void main(String[] args) {
		// Collections Framework
		// Collection과 Map은 인터페이스로 되어 있음.
		// Hash - 해시는 값이 중복될 수 없다는 유니크(Unique)한 특징이 있음.
		// Tree - 이진 트리 순회 방법 중에 중위 순회(In-order traversal) 방식으로 처리됨.
		// Collection을 상속받는 인터페이스나 클래스
		// Collection -> List, Set
		// - List -> ArrayList, LinkedList, Vector
		//   - Vector -> Stack
		// - Set -> HashSet, SortedSet
		//   - SortedSet -> TreeSet
		
		// ArrayList
		// add(int index, E element)
		// add(E e)
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		
		// 3번째 위치에 추가하기
		// -> 뒤의 요소들은 한칸 뒤로 밀림
		// add(int index, E element)
		arr.add(2, 100);
		
		for(int a : arr) {
			System.out.println(a);
		}
		
		System.out.println("-----");
		// 3번째 위치의 100을 200으로 수정
		// set(int index, E element)		
		arr.set(2, 200);
		
		for(int a : arr) {
			System.out.println(a);
		}
		
		System.out.println("-----");
		
		// 3번째 요소 지우기
		// remove(int index)
		arr.remove(2);

		for(int a : arr) {
			System.out.println(a);
		}

		System.out.println("-----");
		
		List<Integer> arr2 = new ArrayList<>();
		arr2.add(1);
		arr2.add(2);

		// 곂치는 요소 지우기
		// removeAll(Collection<?> c)
		arr.removeAll(arr2);
		
		// arr => [1, 2, 3, 4, 5]
		// arr2 => [1, 2]
		// arr.removeAll(arr2);
		// arr=> [3, 4, 5]
		for(int a : arr2) {
			System.out.println(a);
		}

		System.out.println("-----");
		
		// get(int index)
		// size()
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}