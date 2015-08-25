package jdk7.lang;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

public class ObjectsTest {

	@Test
	public void testEquals() {
		String a = "test";
		String b = null;
		Assert.assertFalse(Objects.equals(a, b));
	}

	@Test
	public void testHash() {
		String firstName = "John";
		String lastName = "NoName";
		System.out.printf("Hash of (%s, %s) is %s%n", firstName, lastName, Objects.hash(firstName, lastName));
	}
	
	@Test(expected = NullPointerException.class)
	public void testRequireNotNull() {
		Assert.assertNotNull(Objects.requireNonNull(null));
	}

}
