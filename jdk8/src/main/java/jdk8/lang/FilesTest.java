package jdk8.lang;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FilesTest {
	
	@Test
	public void testLines() throws IOException {
		// Files#lines has to be wrapped in try with resources block
		// otherwise that could cause file descriptors leak
		//
		// https://writeoncereadmany.wordpress.com/2015/10/21/adventures-with-files-lines/
		//
		try (Stream<String> stream = Files.lines(Paths.get("jdk8.gradle"))) {
			List<String> list = stream
					.filter(l -> l.contains("plugin: '"))
					.collect(Collectors.toList());
			System.out.println(list);
		}
	}
	
}
