package file_check_and_read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckAndReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath = "src\\dictionary.txt"; // Update with your file path

		// Check if the file exists
		if (doesFileExist(filePath)) {
			// Read and print words and their meanings
			readWordsAndMeanings(filePath);
		} else {
			System.out.println("The file does not exist at the specified path: " + filePath);
		}
	}

	public static boolean doesFileExist(String path) {
		java.io.File file = new java.io.File(path);
		return file.exists();
	}

	public static void readWordsAndMeanings(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				// Split the line into word and meanings
				String[] parts = line.split("-", 2);
				if (parts.length == 2) {
					String word = parts[0].trim();
					String meanings = parts[1].trim();

					// Print the word and its meanings
					System.out.println(word);
					String[] meaningList = meanings.split(",");
					for (String meaning : meaningList) {
						System.out.println(meaning.trim());
					}
					System.out.println(); // Print a blank line for separation
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error reading the file: " + e.getMessage());
		}
	
	}

}
