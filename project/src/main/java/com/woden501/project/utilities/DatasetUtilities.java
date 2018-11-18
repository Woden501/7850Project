package com.woden501.project.utilities;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.woden501.project.Dataset1Loader;

public class DatasetUtilities {
	public static String getContents(String file) {
		String fileContents = "";
		try {
			Path datasetPath = Path.of(Dataset1Loader.class.getClassLoader().getResource("adult.data").toURI());
			fileContents = Files.readString(datasetPath, StandardCharsets.ISO_8859_1);
		} catch (Exception e) {
			System.out.println("Unable to parse Dataset1.  ExceptionL: " + e.toString());
			System.out.println("Exiting...");
			System.exit(1);
		}
		
		return fileContents;
	}
}
