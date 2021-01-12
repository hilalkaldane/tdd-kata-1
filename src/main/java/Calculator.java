import java.util.Arrays;

public class Calculator {
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] numbersArray;
			numbersArray = numbers.split(",|\\n");
			if (numbersArray.length == 1) {
				return Integer.parseInt(numbers);
			}
			else if (numbersArray.length == 2) {
				return Integer.parseInt(numbersArray[0]) + Integer.parseInt(numbersArray[1]);
			}
			else {
				return Arrays.stream(numbersArray).mapToInt(Integer::valueOf).sum();
			}
		}
	}
}
