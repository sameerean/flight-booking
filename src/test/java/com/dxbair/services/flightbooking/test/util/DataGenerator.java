package com.dxbair.services.flightbooking.test.util;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Function;
import java.util.stream.Stream;

public class DataGenerator {
	
	public static void main(String[] args) throws IOException {
		
		generateDataToFile("names-input.txt", "names-output.csv", line -> new StringBuilder().append(line[0]).append(",")
				.append(line[1]).append(",")
				.append(line[0].toLowerCase()).append(".").append(line[1].toLowerCase()).append("@mycompany.com")
				.append(System.lineSeparator()));
	
		generateDataToFile("names-input.txt", "names-output.csv", line -> new StringBuilder().append(line[0]).append(",")
				.append(line[1]).append(",")
				.append(line[0].toLowerCase()).append(".").append(line[1].toLowerCase()).append("@mycompany.com")
				.append(System.lineSeparator()));
	
	}
	
	public static void generateDataToFile(String inputFile, String outputFile, Function<String[], StringBuilder> dataBuilder) throws IOException {
		
		Stream<String> stream = Files.lines(Paths.get(URI.create(DataGenerator.class.getResource(inputFile).toString())));
//		stream.forEach(System.out::println);
		
		Path outputPath = Paths.get(URI.create(DataGenerator.class.getResource(".").toString() + outputFile));
		Files.deleteIfExists(outputPath);
		
		stream.forEach(line -> {
			System.out.println(">>>>>>>>" + line);
			String[] values = line.split(" ");
			StringBuilder outputLine = dataBuilder.apply(values);
			try {
				Files.write(outputPath, outputLine.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		stream.close();
		
		System.out.println("=============================== Content from the output file ==========================");
		stream = Files.lines(outputPath);
		stream.forEach(System.out::println);
		stream.close();
		System.out.println("=============================== End of output file ==========================");

		
		System.out.println("Check the output file at location: " + outputPath.toString());
	}

}
