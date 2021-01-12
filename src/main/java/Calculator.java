import java.util.Arrays;

public class Calculator {
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] numbersArray;
			numbersArray = numbers.split(",|\\n");
			return Arrays.stream(numbersArray).mapToInt(Integer::valueOf).sum();
		}
	}
}
