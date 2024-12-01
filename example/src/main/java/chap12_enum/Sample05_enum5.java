package chap12_enum;

import java.util.Scanner;

public class Sample05_enum5 {

	public static void main(String[] args) {
		
		// 메서드를 갖는 열거형1
		Scanner sc = new Scanner(System.in);
		System.out.println("목적지 정보");
		for (CITY c : CITY.values()) {
			// ordinal()메서드의 경우 순번이 바뀔 수 있기때문에, 신뢰성을 위해서는 열거형의 값에 순번을 넣어서 관리해야함.
			System.out.printf("%d\t%s(%s)\n", c.ordinal(), c.getDestination(), c.name());
		}
		
		System.out.println("목적지 번호를 선택하세요.");
		int selectedNum = sc.nextInt();
		CITY retCity = CITY.valueOf(selectedNum);
		if (retCity == null) {
			System.out.println("목적지를 확인해주세요.");
			sc.close();
			return;
		}

		switch (retCity) {
		case SEOUL:
			System.out.printf("%s로 출발합니다.", CITY.SEOUL.getDestination());
			break;
		case DAEJEON:
			System.out.printf("%s로 출발합니다.", CITY.DAEJEON.getDestination());
			break;
		case DAEGU:
			System.out.printf("%s로 출발합니다.", CITY.DAEJEON.getDestination());
			break;
		case PUSAN:
			System.out.printf("%s로 출발합니다.", CITY.DAEJEON.getDestination());
			break;
		case GWANGJU:
			System.out.printf("%s로 출발합니다.", CITY.DAEJEON.getDestination());
			break;
		default:
			System.out.println("목적지를 확인해주세요.");
			break;
		}
		System.out.println();
		
		sc.close();
	}

}

enum CITY {
	SEOUL("서울"), DAEJEON("대전"), DAEGU("대구"), PUSAN("부산"), GWANGJU("광주");

	private final String destination;

	private CITY(String destination) {
		this.destination = destination;
	}
	
	
	public String getDestination() {
		return this.destination;
	}

	/**
	 * 입력받은 index로 enum 요소를 반환하는 메서드
	 * 
	 * @param selectNum
	 * @return
	 */
	public static CITY valueOf(int selectNum) {
		CITY city = null;
		for (CITY c : CITY.values()) {
			// ordinal() => 이 열거 상수의 ordinal(열거 선언의 해당 위치, 초기 상수에 0의 ordinal이 할당됨)을 반환함.
			if (selectNum == c.ordinal()) {
				city = c;
				break;
			}
		}
		return city;
	}
}

enum CITY2 {
	SEOUL(0, "서울"), DAEJEON(1, "대전"), DAEGU(2, "대구"), PUSAN(3, "부산"), GWANGJU(4, "광주");

	private final String destination;
	private final int order;
	
	private CITY2(int order, String destination) {
		this.order = order;
		this.destination = destination;
	}
	
	public int getOrder() {
		return order;
	}
	
	public String getDestination() {
		return destination;
	}

}