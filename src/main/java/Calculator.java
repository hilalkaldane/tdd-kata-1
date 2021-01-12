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
			checkForNegatives(numbersArray);
			return sumOfNumbers(numbersArray);
		}
	}

	private static void checkForNegatives(String[] numbersArray) {
		int[] negativeElements=Arrays.stream(numbersArray).parallel().mapToInt(Integer::valueOf).filter(x->x<0).toArray();
		if(negativeElements.length>0)
		{

			StringBuilder errorMessage = new StringBuilder("negatives not allowed - ");
			for (int i = 0; i < negativeElements.length-1; i++) {
				errorMessage.append(negativeElements[i]);
				errorMessage.append(",");
			}
			errorMessage.append(negativeElements[negativeElements.length-1]);
			throw new RuntimeException(String.valueOf(errorMessage));
		}
	}

	private static int sumOfNumbers(String[] numbersArray) {
		return Arrays.stream(numbersArray).mapToInt(Integer::valueOf).sum();
	}

	private static String[] nonEmptyAddition(String numbers) {
		String[] numbersArray;
		if (numbers.startsWith("//")) {
			//splits numbers based on delimiter provided
			Pattern pattern = Pattern.compile("//(.*)\n(.*)");
			Matcher matcher = pattern.matcher(numbers);
			matcher.find();
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
