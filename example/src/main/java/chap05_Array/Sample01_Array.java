package chap05_Array;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Sample01_Array {
	public static void main(String[] args) {
		// 배열
		// (자료형)[] 이름 = new 자료형(배열의 개수)
		int[] arr1 = new int[10];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i;
			System.out.println(arr1[i]);
		}
		int[] arr2 = { 100, 200, 300 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		// 다차원 배열
		int[][] arr3 = new int[5][3];
		// 특정 줄만 재정의하기
		arr3[1] = new int[1];
		// 행의 길이
		System.out.println("길이 : " + arr3.length);
		System.out.println("특정 행의 길이 : " + arr3[0].length);
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				System.out.println(i + ", " + j);
			}
		}
		
		// Split사용하기
		String str = "A|B|C|D|E";
		// \\|, \\&, \\*, =, \\+, \\^, - 등등..
		String[] names = str.split("\\|");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		// Arrays 클래스
		// Arrays.toString()
		// => 1차원 배열 출력
		System.out.println(Arrays.toString(names));
		
		// Arrays.deepToString()
		// => 2차원 배열 이상일 경우 출력
		System.out.println(Arrays.deepToString(arr3));

		String[] names2 = str.split("\\|");
		// 배열의 비교
		// 잘못된 비교의 예
		System.out.println("names: " + Arrays.toString(names));
		System.out.println("names2: " + Arrays.toString(names2));
		System.out.println(names == names2);
		
		// Arrays.equals()
		// 배열간의 내용이 같은지 비교
		System.out.println(Arrays.equals(names, names2));
		
		// Arrays.deepEquals()
		// 다차원 배열간의 내용이 같은지 비교
		System.out.println(Arrays.deepEquals(names, names2));
		
		// Arrays.copyOf()
		// 범위를 넘을 경우 null 값이 들어감.
		// 배열을 0부터 정해진 길이만큼 복사함.
		// A, B, C, D, E
		// A, B
		String[] names3 = Arrays.copyOf(names2, names2.length - 3);
		System.out.println(Arrays.toString(names3));
		// 배열을 정해진 범위만큼 복사함
		// C, D
		String[] names4 = Arrays.copyOfRange(names2, 2, 4);
		System.out.println(Arrays.toString(names4));
		
		// Arrays.sort()
		// 오름차순으로 정렬
		String[] names5 = { "D", "B", "A", "C", "F", "E" };
		Arrays.sort(names5);
		System.out.println(Arrays.toString(names5));
		
		// Arrays.binarySearch()
		// 이진 탐색은 배열에서 데이터를 탐색하는 알고리즘임.
		// 이진 탐색을 실행할 경우 해당 배열이 미리 정리되어있어야함.
		// 해당하는 Key의 index값을 return함.
		System.out.println(Arrays.binarySearch(names5, "B"));
		
		// Arrays.asList()
		// List자료형에 배열을 쉽게 추가하는 메서드
		int[] arr_int1 = new int[3];
		arr_int1[0] = 1;
		arr_int1[1] = 2;
		arr_int1[2] = 3;
		// asList로 List를 생성할 경우 길이가 고정되어 추가, 삭제가 안됨.
		List<Integer> lst_int1 = Arrays.asList(1, 2, 3);
		System.out.println(lst_int1);
		
		// asList를 사용해 List에 추가하고싶지만 데이터를 추가하고 싶을 경우에는
		// ArrayList로 감싸서 생성하면 됨.
		List<String> lst_str1 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
		lst_str1.add("D");
		System.out.println(lst_str1);
	}
}