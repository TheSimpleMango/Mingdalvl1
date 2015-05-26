import java.util.Random;

public class Magic8Ball {
	final static int numOfInts = 4;
	
	public static void main(String[] args) {
		int rand = new Random().nextInt(numOfInts) + 1;
		if (rand == 1) {
			System.out.println("HELLZ NAW");
		}
		else if (rand == 2) {
			System.out.println("LOLZ");
		}
		else if (rand == 3) {
			System.out.println("GO DIE IN A HOLE");
		}
		else if (rand == 4) {
			System.out.println("MERBEH");
		}
	}
}
