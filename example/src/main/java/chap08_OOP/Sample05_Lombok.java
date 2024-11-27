package chap08_OOP;

// lombok 사용
// @Data이 포함하는 것
// - @ToString
// - @EqualsAndHashCode
// - @Getter
// - @Setter
import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
// getter() 메서드
// 접두사 get을 사용
// 멤버 변수의 첫 글자만 대문자로 작성
// 멤버 변수의 리턴값이 있다.
// 매개변수가 없다.
@Setter
// setter() 메서드
// 접두사 set을 사용
// 멤버 변수의 첫 글자만 대문자로 작성
// 리턴 값이 없다.
// 매개변수가 있다.
@ToString
@NoArgsConstructor // 멤버 필드가 없는 기본 생성자
@RequiredArgsConstructor // 꼭 필요한 멤버 필드를 매개 변수로 하는 생성자 - @NonNull이나 final이 필요
@AllArgsConstructor // 멤버 필드들 모두를 매개변수로 사용
class Sample05_1 {
	
	@NonNull // 리터럴 값으로 null이 올 수 없다.
	private String name;
	private String color;
	
}

@Data
/*
@Data 애너테이션을 사용하면 아래의 애너테이션 효과를 얻을 수 있음.
 - @ToString
 - @EqualsAndHahCode
 - @Getter
 - @Setter
 - @RequiredArgsConstructor
*/
class Sample05_2 {
	
	private String name;
	private String color;
	
	@Builder
	public Sample05_2(String name, String color) {
	/*
	매개변수 수에 의해서 여러개의 생성자를 만들게 됨.
	매개변수 갯수가 변경될 경우 대응이 불편함.
	빌더 패턴이 완성되면 생성자에 정의된 매개변수의 범위 내에서 순서에 상관없이 마음껏 초깃값을 넣을 수 있음.
	*/
		this.name = name;
		this.color = color;
	}
}

public class Sample05_Lombok {

	public static void main(String[] args) {
		Sample05_2 s = Sample05_2.builder()
				.name("A")
				.color("Red")
				.build();
		System.out.println(s.toString());
	}

}