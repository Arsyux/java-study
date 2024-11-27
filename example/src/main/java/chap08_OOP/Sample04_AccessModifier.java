package chap08_OOP;

class Sample04 {
	
	// 접근 제어자
	// public - public으로 선언된 클래스, 변수, 메소드는 다른 패키지에서도 자유롭게 접근할 수 있음.
	// protected - protected로 선언된 변수나 메소드는 같은 패키지 내 또는 상속을 받은 자식 클래스에서 접근할 수 있음.
	// default(접근 제어자를 생략한 경우) - 같은 패키지 내에서만 접근할 수 있음.
	// private - private으로 선언된 변수나 메소드는 해당 클래스 내에서만 접근할 수 있고, 외부에서는 접근할 수 없음.
	private String id;
	private int password;
	
	// 생성자
	public Sample04(String id, int password) {
		this.id = id;
		// 암호화하여 저장
		setPassword(password);
	}
	
	// 캡슐화(Encapsulation)
	// -> 외부에서 내부의 내용을 숨겨 데이터를 보호하고 다른 객체의 접근을 제한하는 것
	// 멤버 변수를 private로 선언하고, getter와 setter를 통해 데이터에 접근
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	// 비밀번호를 설정할 수는 있지만 외부에서 가져올 수는 없음
	public void setPassword(int password) {
		// 암호화하여 저장
		this.password = encryption(true, password);
	}
	private int getPassword() {
		// 복호화한 값을 반환
		return encryption(false, password);
	}
	
	/**
	 * 암호화 및 복호화 함수
	 * @param ed 파라미터의 값이 true이면 암호화를 false이면 복호화를 합니다.
	 * @param password
	 * @return
	 * @since 1.0
	 */
	private int encryption(boolean ed, int password) {
		if(ed) { return password + 152424; }
		else { return password - 152424; }
	}
	
	public boolean login(String id, int password) {
		if(!this.id.equals(id)) { return false; }
		if(this.getPassword() != password) { return false; }
		return true;
	}

	@Override
	public String toString() {
		return "Sample04 [id=" + id + ", password=********]";
	}
	
}

public class Sample04_AccessModifier {

	public static void main(String[] args) {
		Sample04 s = new Sample04("아이디1", 123);
		System.out.println(s.toString());
		
		String id = s.getId(); // 아이디는 가져올 수 있으나 비밀번호는 private라 가져올 수 없음
		int password = 1234;
		if(s.login(id, password)) {	System.out.println("로그인에 성공하였습니다."); }
		else { System.out.println("로그인에 실패하였습니다."); }
		
		id = s.getId();
		password = 123;
		if(s.login(id, password)) {	System.out.println("로그인에 성공하였습니다."); }
		else { System.out.println("로그인에 실패하였습니다."); }	
	}
}