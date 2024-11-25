package chap02_Type;

// 단축키 [Ctrl + Shift + O]를 눌러서 자동으로 import하는걸 추천
import java.util.Random;

public class Sample06_Random {

	public static void main(String[] args) {
		// Random값 생성
		
		// 1. Random객체 사용.
		Random r = new Random();
		// 1~100 사이의 값 출력
		// nextInt(100)함수를 통해 0~99사의 값을 가져온 뒤에 + 1을 하여 1~100 사이의 값을 가져옵니다.
		System.out.println(r.nextInt(100) + 1);
		
		// 2. Math.random() 사용.
		// 1~50 사이의 값 출력
		// Math.random()값에 * 50을 하여 0~49 사이의 값을 가져오게 한 뒤에 + 1을 하여 1~50 사이의 값을 가져옵니다.
		// 이후 int로 형 변환을 해주어서 출력합니다.
		System.out.println((int) (Math.random() * 50 + 1));
	}
}