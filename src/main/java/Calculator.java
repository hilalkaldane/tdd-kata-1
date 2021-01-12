import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		else {
			String[] numbersArray = nonEmptyAddition(numbers);
			//if negative exists, throws error.
			checkForNegatives(numbersArray);
			//else returns sum of error
			return sumOfNumbers(numbersArray);
		}
	}

	private static String[] nonEmptyAddition(String numbers) {
		String[] numbersArray;
		//check for custom delimiter existence
		if (numbers.startsWith("//")) {
			//splits numbers based on delimiter provided
			Pattern pattern = Pattern.compile("//(.*)\n(.*)");
			Matcher matcher = pattern.matcher(numbers);
			matcher.find();
			String delimiter = matcher.group(1);
			//checks if multiple delimiters are provided.
			if (delimiter.matches("\\[.*\\]")) {
				delimiter = createMultipleDelimiterArray(delimiter);
			}
			numbers = matcher.group(2);
			numbersArray = numbers.split(delimiter);
		}
		else {
			//splits input by delimiter as , and \n
			numbersArray = numbers.split(",|\\n");
		}
		return numbersArray;
	}

	private static String createMultipleDelimiterArray(String delimiter) {
		List<String> delimitersList = new ArrayList<>();
		int loc = 0;
		while (loc < delimiter.length()) {
			//start of delimiter
			if (delimiter.charAt(loc) == '[') {
				loc++;
				StringBuilder internalDelimiter = new StringBuilder("(");
				while (delimiter.charAt(loc) != ']') {
					internalDelimiter.append("\\").append(delimiter.charAt(loc++));
				}
				delimitersList.add(internalDelimiter.append(")").toString());
				//end of delimiter
				loc++;
			}
		}
		if (delimitersList.size() != 0) {
			delimiter = "";
		}
		for (String s : delimitersList) {
			delimiter += s + "|";
		}
		return delimiter.substring(0, delimiter.length() - 1);
	}

	private static void checkForNegatives(String[] numbersArray) {
		int[] negativeElements = Arrays.stream(numbersArray).parallel().mapToInt(Integer::valueOf).filter(x -> x < 0).toArray();
		if (negativeElements.length > 0) {
			StringBuilder errorMessage = new StringBuilder("negatives not allowed - ");
			for (int i = 0; i < negativeElements.length - 1; i++) {
				errorMessage.append(negativeElements[i]);
				errorMessage.append(",");
			}
			errorMessage.append(negativeElements[negativeElements.length - 1]);
			throw new RuntimeException(String.valueOf(errorMessage));
		}
	}

	private static int sumOfNumbers(String[] numbersArray) {
		//ignores number greater than 1000 and returns sum
		return Arrays.stream(numbersArray)
				.mapToInt(Integer::valueOf)
				.filter(n -> n <= 1000)
				.sum();
	}
}
