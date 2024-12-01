package chap11_CollectionFramework;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample05_Iterator2 {

	public static void main(String[] args) {
		var list = new ArrayList<String>();
		list.add("dog");
		list.add("cat");
		list.add("lion");
		
		System.out.println(list);
		System.out.println("size : " + list.size());

		// for문을 이용하여 list의 데이터를 삭제하는 경우에는 길이가 변경되기때문에 오류 방지를 위해 따로 index를 만드는 등의 작업이 필요.
		// Iterator를 사용하여 데이터를 삭제하면 요소를 삭제한 후 다음 요소로 자동 이동하므로 인덱스 오류나 건너뛰기 현상을 방지할 수 있음.
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String item = it.next();
			System.out.println(item);
			if("cat".equals(item)) {
				// Iterator에서 삭제하면 원본 list에서도 삭제된다는 것에 유의
				it.remove();
			}
		}
		
		System.out.println(list);
		System.out.println("size : " + list.size());
	}

}