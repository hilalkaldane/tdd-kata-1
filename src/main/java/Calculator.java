import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int add(String numbers) {
		if(numbers.isEmpty())
		{
			return 0;
		}
		else
		{
			String[] numbersArray = nonEmptyAddition(numbers);
			return Arrays.stream(numbersArray).mapToInt(Integer::valueOf).sum();

		}
	}

	private static String[] nonEmptyAddition(String numbers) {
		String[] numbersArray;
		if (numbers.startsWith("//")) {
			//splits numbers based on delimiter provided
			Pattern pattern = Pattern.compile("//(.*)\n(.*)");
			Matcher matcher = pattern.matcher(numbers);
			String delimiter=matcher.group(1);
			numbers=matcher.group(2);
			numbersArray = numbers.split(delimiter);
		}
		else {
			//splits input by delimiter as , and \n
			numbersArray = numbers.split(",|\\n");
		}
		return numbersArray;
	}
}
