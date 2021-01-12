import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
	@Test
	public void shouldReturnZeroIfEmpty()
	{
		assertEquals(0,Calculator.add(""));
	}
}
