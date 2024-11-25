package chap03_Template;

/**
 * 작성자 이름은 윈도 계정명이 자동으로 들어갑니다.
 * 
 * @author arsyux
 */
public class Sample01_Template {

	// 코드 템플릿 (Code Templates)
	// 단축키: [Alt + Shift + J]
	// 메서드의 주석을 자동으로 만들어줌.
	// Window - Preferences - Java - Code Style - Code Templates에서 패턴을 수정할 수 있음.
	
	// 패턴 수정을 할 때 [Insert Variable...] 버튼을 활용해서 여러 정보를 자동으로 바인딩 할 수 있음.
	// 템플릿에서 자주 사용하는 변수
	// ${date} 현재 날짜
	// ${package_name} 패키지명
	// ${enclosing_method} 메서드명
	// ${file_name} 파일명
	// ${project_name} 프로젝트명
	// ${return_type} 리턴 타입
	// ${tags} 파라미터와 리턴 타입
	// ${time} 현재 시간
	// ${type_name} 타입명
	// ${user} 시스템 계정명
	// ${year} 년도
	/**
	 * 메인 함수
	 * 
	 * @param args
	 * @since 1.0
	 */
	public static void main(String[] args) {
		// 한줄 주석
		// 실무에서는 상단 주석 or 우측 주석으로 미리 코딩 스타일을 정의하여 사용함.
		// 상단에 주석을 표기하는 경우
		int num = 100; // 우측에 표기하는 경우
		
		/* 여러줄 주석
		한 번에 여러 줄의 소스코드를 삭제하지않고 무력화시킬 때 많이 사용함.
		System.out.println(num);
		System.out.println(num + 1);
		System.out.println(num + 2);
		*/
		
		System.out.println(genNum(num));
	}

	
	
	/**
	 * number이하의 자연수를 생성하는 함수입니다.
	 * 
	 * @param number
	 * @return
	 * @since 1.0
	 */
	public static int genNum(int number) {
		return (int) (Math.random() * number + 1);
	}
}