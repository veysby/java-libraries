package jdk7.lang;

import org.junit.Assert;
import org.junit.Test;

public class LangChangesTest {
	
	@Test
	public void testIntegerCompare() {
		int a = Integer.MAX_VALUE;
		int b = Integer.MIN_VALUE;
		// Result of a - b is out of int range, so it is much safe to use Integer.compare
		Assert.assertEquals(1, Integer.compare(a, b));
	}
	
	@Test
	public void testParsePositive() {
		// +4 is a valid number since jdk 7
		Assert.assertEquals(4, Integer.parseInt("+4"));
	}
	
}
