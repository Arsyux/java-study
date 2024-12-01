package chap12_enum;

public class Sample01_enum1 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// 색 집합
		final int RED = 1;
		final int BLUE = RED + 1;
		final int ORANGE = BLUE + 1;

		// 크기 집합
		final int SMALL = 1;
		final int MIDIUM = SMALL + 1;
		final int LARGE = MIDIUM + 1;

		int inputColor = RED;

		// 색과 크기를 비교하였는데 색으로 결과값이 나옴.
		System.out.println(inputColor == RED ? "Red" : "Not Red");
		System.out.println(inputColor == SMALL ? "Red" : "Not Red");
		System.out.println("ORANGE : " + ORANGE);
		System.out.println("LARGE  : " + LARGE);
		
		// 클래스를 만들어서 각각의 집단을 구분함
		Color inputColorClass = Color.RED;
		System.out.println(inputColorClass.equals(Color.RED) ? "Red" : "Not Red");
		System.out.println(inputColorClass.equals(Size.SMALL) ? "Red" : "Not Red");
	}

}

class Color {
	final static Color RED = new Color();
	final static Color BLUE = new Color();
	final static Color ORANGE = new Color();
}

class Size {
	final static Size SMALL = new Size();
	final static Size MIDIUM = new Size();
	final static Size LARGE = new Size();
}