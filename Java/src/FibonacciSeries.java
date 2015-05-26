public class FibonacciSeries {
	public static void main(String[] args) {
		int x = 1;
		int y = 1;
		System.out.println("1 \n1");
		for (int i = 1; i <= 10; i++) {
			x += y;
			System.out.println(x);
			y = x - y;
		}
	}
}
