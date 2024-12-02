package chap14_Annotation;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;

@Retention(RUNTIME)
@Target(TYPE)
@interface Friend1 {
	String name();
}

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@interface Friend2 {
	String[] value();
}

// 반복 가능한 애너테이션 선언
@Repeatable(Friends.class)
@interface Friend3 {
	String name();
}

@Retention(RUNTIME)
@interface Friends {
	Friend3[] value();
}

@Friend1(name = "구미호")
class annoTest1 {
}

@Friend2({ "구미호", "둘리", "스누피" })
class annoTest2 {

	public void printInfo() {
		Friend2 f2 = this.getClass().getAnnotation(Friend2.class);
		for (String friend : f2.value()) {
			System.out.println(friend);
		}
	}

}

// @Repeatable 선언으로 반복해서 사용할 수 있음
@Friend3(name = "구미호")
@Friend3(name = "둘리")
@Friend3(name = "스누피")
class annoTest3 {

	public annoTest3() {
	}

	public void printInfo() {
		Friends fs = this.getClass().getAnnotation(Friends.class);

		System.out.println("\nAnnotation Info");
		System.out.println("Arrays.toString()");
		System.out.println(Arrays.toString(fs.value()));

		System.out.println("\nfor expression");
		for (int i = 0; i < fs.value().length; i++) {
			System.out.println(fs.value()[i]);
		}

		System.out.println("\nLambda & Stream");
		Arrays.stream(fs.value()).forEach(System.out::println);

		System.out.println("\nValue Info");
		System.out.println("for expression");
		for (int i = 0; i < fs.value().length; i++) {
			Friend3 f3 = fs.value()[i];
			System.out.println(f3.name());
		}

		System.out.println("\nLambda & Stream");
		Arrays.stream(fs.value()).forEach(v -> {
			System.out.println(v.name());
		});
	}

}

public class Sample04_Repeatable {

	public static void main(String[] args) {
		annoTest2 at2 = new annoTest2();
		at2.printInfo();

		annoTest3 at3 = new annoTest3();
		at3.printInfo();
	}

}