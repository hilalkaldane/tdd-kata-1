import java.util.Arrays;

public class Calculator {
	public static int add(String numbers) {
		if(numbers.isEmpty())
		{
			return 0;
		}
		else
		{
			String[] numbersArray;
			if (numbers.startsWith("//")) {
				//splits numbers based on delimiter provided
				numbersArray = numbers.split("\\n")[1].split(String.valueOf(numbers.charAt(2)));
			}
			else {
				//splits input by delimiter as , and \n
				numbersArray = numbers.split(",|\\n");
			}
			final int sum;
			sum = Arrays.stream(numbersArray).mapToInt(Integer::valueOf).sum();
			return sum;
		}
	}
}
