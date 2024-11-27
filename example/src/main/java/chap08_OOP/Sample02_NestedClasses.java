package chap08_OOP;

/**
 * 중첩 클래스(Nested Class)<br />
 * 클래스 내부에 클래스를 만들 경우 중첩클래스라고 함.<br />
 * 밖에 있는 클래스를 외부 클래스(OuterClass)라고 하고 안쪽에 있는 클래스를 내부 클래스(InnerClass) 라고 함.<br />
 * <br />
 * 중첩 클래스의 특징<br />
 * 1. 코드의 재사용이 어려움.<br />
 * 2. 내부 클래스는 외부 클래스에 접근이 용이함.
 */
class Student {
	
	String name;
		
	public Student(String name) {
		this.name = name;
	}
	
	/**
	 * 1. 인스턴스 내부 클래스 (Instance Inner classes)<br />
	 * OuterClass(Student)안에 InnerClass(Score)가 있는 형태임.<br />
	 * 외부 클래스의 멤버 클래스로 멤버 변수와 같은 레벨에 위치함.<br />
	 * 클래스이기 때문에 new 키워드를 사용하여 클래스 객체를 생성해 줘야함.<br />
	 * 내부 클래스를 사용하면 컴파일 시 따로 분리하여 컴파일됨.
	 */
	public class Score {
		
		int eng;
		int mat;

		public void showInfo() {
			// 외부 클래스(Student)의 자원에 쉽게 접근 가능함.
			System.out.println("name: " + name);
			System.out.println("eng: " + eng);
			System.out.println("mat: " + mat);
		}
	}

	/**
	 * 2. 지역클래스 (Local Inner Classes)<br />
	 * 클래스 안에 메서드가 있고 그 메서드 내에 내부 클래스가 들어가 있는 형태.<br />
	 * 메서드 안의 변수를 로컬 변수라고 하는데 지역 클래스도 로컬 변수와 마찬가지로 메서드 안으로 사용 범위가 제한됨.<br />
	 * 즉, 메서드 안에서 내부 클래스를 정의하고, 같은 메서드 안에서만 내부 클래스를 인스턴스화 할 수 있음.
	 */
	void LocalMethod() {
		// 로컬 변수
		int age = 20;
		
		// 지역 클래스
		class LocalClass {
			
			public void myAge() {
				System.out.println("age: " + age);
			}
			
		}
		
		// 메서드 안에서만 지역 클래스를 인스턴스화 할 수 있음.
		LocalClass innerClass = new LocalClass();
		innerClass.myAge();
	}
	
	// 정적 내부 클래스는 static 멤버 변수만 접근이 가능함.
	static int age;
	
	/**
	 * 4. 정적 중첩 클래스 (Static Nested Classes)<br />
	 * 그냥 정의하면 인스턴스 클래스, static을 붙히면 정적 멤버 클래스가 됨.<br />
	 * 내부 클래스는 외부 클래스의 인스턴스를 생성한 뒤에 내부 클래스의 인스턴스를 생성할 수 있었음.<br />
	 * 하지만 정적 중첩 클래스에서는 외부 클래스를 인스턴스화하지도 않고서 내부 클래스의 객체를 생성할 수 있음.
	 */
	public static class StaticScore {
		
		int eng;
		int mat;

		public StaticScore(int age) {
			// 내부 클래스의 this는 내부 클래스를 참조하기때문에 this.name이 아니라 Student.name을 사용.
			Student.age = age;
		}

		public void show() {
			// 외부 클래스의 자원에 쉽게 접근
			System.out.println("Age: " + age);
			System.out.println("Eng: " + eng);
			System.out.println("Mat: " + mat);
		}
	}
}

/**
 * 3. 익명 내부 클래스 (Anonymous Inner classes)<br />
 * 익명 클래스는 다른 내부 클래스와는 다르게 즉석에서 클래스를 만들어서 사용함.<br />
 * 클래스가 따로 존재하지 않고 객체를 생성해서 바로 사용하기 때문에 만들어진 지역(Local)에서만 사용가능함.<br/>
 * 일반적으로 추상 클래스나 인터페이스의 메서드를 대체해야 할 때 사용함.
 */
interface Bow {
	
	public String sayHello();
	
	public String sayBye();
	
}

public class Sample02_NestedClasses {

	public static void main(String[] args) {
		// 1. 인스턴스 내부 클래스
		Student std = new Student("Arsyux");
		// Student객체를 생성한 후에 new를 사용하여 내부 클래스 객체를 생성
		Student.Score stdscore = std.new Score();
		stdscore.eng = 100;
		stdscore.mat = 50;
		stdscore.showInfo();
		
		// 2. 지역클래스
		std.LocalMethod();
		
		// 3. 익명 내부 클래스
		// 이용 빈도 수가 적은 클래스를 만드는 것 보다 일회용으로 사용할 경우 익명 클래스를 많이 사용함.
		String name = std.name;
		Bow bow = new Bow() {
			
			@Override
			public String sayHello() {
				return "Hello, " + name + "!";
			}
			
			@Override
			public String sayBye() {
				// this가 메인 클래스인 Sample02가 아닌 Bow를 지칭하는 this가 됨.
				// 즉, 내부 클래스에서 this를 사용하게 되면 내부 클래스 객체를 가리키는 this가 됨.
				System.out.println(this.sayHello());
				return "Bye, " + name + "!";
			}
		};
		System.out.println(bow.sayBye());
		
		// 4. 정적 중첩 클래스
		Student.StaticScore staticScore = new Student.StaticScore(20);
		staticScore.eng = 80;
		staticScore.mat = 60;
		
		staticScore.show();
	}
}