package jdk7.lang;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class NioTest {

	@Test
	public void testRelativize() {
		Path dirTest1 = Paths.get("/test1");
		Path dirTest2 = Paths.get("/test2");
		Assert.assertEquals("../test2", dirTest1.relativize(dirTest2).toString());
	}
	
	@Test
	public void testCurrentFolder() {
		Path dir = Paths.get(".");
		Assert.assertNotEquals(".", dir.toAbsolutePath().toString());
	}

	@Test
	public void testNormalize() {
		Path path = Paths.get("/test1/../test2/./hello.txt");
		Assert.assertEquals("/test2/hello.txt", path.normalize().toString());
	}

}
