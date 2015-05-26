import java.io.IOException;

public class NasaCount {
	public static void main(String[] args) throws IOException, InterruptedException {
		for (int i = 10; i != 0; i--) {
			Runtime.getRuntime().exec("say " + i);
			Thread.sleep(1000);
		}
		Runtime.getRuntime().exec("say Blastoff!");
	}
}
