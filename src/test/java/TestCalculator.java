import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestCalculator {
	@Test
	public void shouldReturnZeroIfEmpty() {
		try {
			assertEquals(0, Calculator.add(""));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}

	@Test
	public void shouldReturnNumber() {
		try {
			assertEquals(1, Calculator.add("1"));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}

	@Test
	public void shouldReturnSumOf2NumbersDelimitedByComma() {
		try {
			assertEquals(3, Calculator.add("1,2"));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}

	@Test
	public void shouldReturnSumOfNumbersOfAnyCountDelimitedByComma() {
		try {
			assertEquals(6, Calculator.add("1,2,3"));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}

	@Test
	public void shouldReturnSumDelimitedByCommaAndNewLine() {
		try {
			assertEquals(6, Calculator.add("1\n2,3"));
		}
		catch (Exception e) {
			assertNull(e);
		}
		/*		this will throw error
				assertEquals(6,Calculator.add("1,\n2,3"));
		 */
	}

	@Test
	public void shouldReturnSumWithInputGivenWithSpecifiedDelimiter() {
		try {
			assertEquals(3, Calculator.add("//;\n1;2"));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}

	@Test
	public void shouldThrowExceptionForNegative() {
		try {
			Calculator.add("//;\n-1;2");
		}
		catch (Exception e) {
			assertEquals("negatives not allowed - -1", e.getMessage());
		}
	}

	@Test
	public void shouldCheckForNumberSmallerThan1001() {
		try {
			assertEquals(2,Calculator.add("//;\n1001;2"));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}
	@Test
	public void checkForMultipleDelimiters() {
		try {
			assertEquals(6,Calculator.add("//[*][%]\n1*2%3"));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}
	public void checkForMultipleDelimitersWithAnySize() {
		try {
			assertEquals(6,Calculator.add("//[***]\n1***2***3"));
		}
		catch (Exception e) {
			assertNull(e);
		}
	}
}
