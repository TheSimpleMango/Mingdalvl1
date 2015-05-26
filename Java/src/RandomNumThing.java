
public class RandomNumThing {
	public static void main(String[] args) {
		int x = 1;
		while (x == 1) {
			double ranNum;
			double one = 0;
			double zero = 0;
			for (int i = 1; i <= 10000; i++) {
				ranNum = Math.random();
				if (ranNum > 0.5) {
					one++;
				}
				else if (ranNum < 0.5) {
					zero++;
				}
			}
			double onePercent = one / (one + zero);
			double zeroPercent = zero / (one + zero);
			System.out.printf("%.2f  %.2f \n", onePercent, zeroPercent);
		}
	}
}
