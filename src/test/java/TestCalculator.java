import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
	@Test
	public void shouldReturnZeroIfEmpty()
	{
		assertEquals(0,Calculator.add(""));
	}
	@Test
	public void shouldReturnNumber()
	{
		assertEquals(1,Calculator.add("1"));
	}
	@Test
	public void shouldReturnSumOf2NumbersDelimitedbyComma()
	{
		assertEquals(3,Calculator.add("1,2"));
	}
	@Test
	public void shouldReturnSumOfNumbersOfAnyCountDelimitedbyComma()
	{
		assertEquals(6,Calculator.add("1,2,3"));
	}
	@Test
	public void shouldReturnSumDelimitedbyCommaAndNewLine()
	{
		assertEquals(6,Calculator.add("1\n2,3"));
		/*		this will throw error
				assertEquals(6,Calculator.add("1,\n2,3"));
		 */
	}
}
