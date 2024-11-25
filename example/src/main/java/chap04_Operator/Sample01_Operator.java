package chap04_Operator;

public class Sample01_Operator {

	public static void main(String[] args) {
		// 연산자
		int num1 = 10;
		int num2 = 5;
		
		// 산술 연산자
		System.out.println("산술 연산자");
		System.out.println("num1 + num2: " + (num1 + num2));
		System.out.println("num1 - num2: " + (num1 - num2));
		System.out.println("num1 * num2: " + (num1 * num2));
		System.out.println("num1 / num2: " + (num1 / num2));
		System.out.println("num1 % num2: " + (num1 % num2));
		
		// 증감 연산자
		System.out.println("증감 연산자");
		// 전치 증감 연산자
		System.out.println("++num1: " + ++num1);
		System.out.println("--num1: " + --num1);
		// 후치 증감 연산자
		System.out.println("num1++: " + num1++);
		System.out.println("num1--: " + num1--);
		
		// 비교 연산자
		System.out.println("비교 연산자");
		System.out.println("num1 < num2: " + (num1 < num2));
		System.out.println("num1 > num2: " + (num1 > num2));
		System.out.println("num1 <= num2: " + (num1 <= num2));
		System.out.println("num1 >= num2: " + (num1 >= num2));
		System.out.println("num1 == num2: " + (num1 == num2));
		System.out.println("num1 != num2: " + (num1 != num2));
		
		// 논리 연산자
		System.out.println("논리 연산자");
		System.out.println("true && true: " + (true && true));
		System.out.println("false || true: " + (false || true));
		System.out.println("true ^ true: " + (true ^ false)); // XOR : 다르면 참, 같으면 거짓
		System.out.println("!false: " + (!false));
		
		// 비트 연산자
		// num1 = 10 = 00001010
		// num2 = 5 = 00000101
		System.out.println("비트 연산자");
		System.out.printf("num1: %d = [%32s] \n", num1, Integer.toBinaryString(num1));
		System.out.printf("num2: %d = [%32s] \n", num2, Integer.toBinaryString(num2));
		System.out.printf("num1 & num2: %d = [%32s] \n", num1 & num2, Integer.toBinaryString(num1 & num2));
		System.out.printf("num1 | num2: %d = [%32s] \n", num1 | num2, Integer.toBinaryString(num1 | num2));
		System.out.printf("num1 ^ num2: %d = [%32s] \n", num1 ^ num2, Integer.toBinaryString(num1 ^ num2));
		// ~연산 과정
		// 예를 들어 8bit 공간에 7이라느 숫자가 있다고 하면
		// 7 = 00000111 이고, not 비트연산을 하면
		// ~7 = 11111000 임.
		// 여기서 11111000을 보수 계산하여 구하면 00001000 = 8 이고
		// 음수이므로 ~7 = -8이 됨.
		// 즉, ~연산의 값은 부호를 바꾼 후, 1을 빼서 구할 수 있다.
		System.out.printf("~num1: %d = [%32s] \n", ~num1, Integer.toBinaryString(~num1));
		System.out.println("왼쪽 시프트 연산자");
		System.out.printf("num1 << 1: %d = [%32s] \n", num1 << 1, Integer.toBinaryString(num1 << 1));
		
		int num3 = -10;
		System.out.println("오른쪽 시프트 연산자");
		// 음수의 경우에는 음수를 유지하기 위해서 1이 채워짐
		System.out.println("num3: " + num3);
		System.out.printf("num3 >> 1: %d = [%32s] \n", num3 >> 1, Integer.toBinaryString(num3 >> 1));

		System.out.println("Unsigned right shift");
		// Unsigned right shift는 0으로 채움.
		System.out.printf("num3 >>> 1: %d = [%32s] \n", num3 >>> 1, lpad(Integer.toBinaryString(num3 >>> 1), 32, "0"));
		
		
		// 복합대입 연산자
		System.out.println("복합대입 연산자");
		num1 += 1; // 11
		num1 -= 1; // 10
		num1 *= 4; // 40
		num1 /= 2; // 20
		num1 %= 13; // 7
		num1 &= num2; // 5
		num1 |= num2; // 5
		num1 <<= 1; // 10
		num1 >>= 1; // 5
		// num1을 오른쪽으로 2비트만큼 이동하고 왼쪽의 빈 공간을 모두 0으로 채워서 num1에 대입.
		num1 >>>= 2; // 1
		num1 ^= num2; // 4
		System.out.println(num1);

		// 삼항 연산자
		System.out.println("삼항 연산자");
		int num4 = num1 < num2 ? num1 : num2;
		System.out.println(num4);
	}
	
	public static String lpad(String context, int len, String ch) {
		String str = context;
		if(context.length() < len) {
			for(int i = 0; i < len - context.length(); i++) {
				str = ch + str;
			}
		}
		return str;
	}
}