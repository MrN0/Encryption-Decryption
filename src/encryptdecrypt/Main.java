package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import encryptdecrypt.argument.ArgumentFactory;
import encryptdecrypt.argument.ArgumentType;
import encryptdecrypt.encryptor.Encryptor;
import encryptdecrypt.encryptor.ShiftingEncryptor;
import encryptdecrypt.encryptor.UnicodeEncryptor;

public class Main {

	public static void main(String[] args) {
		try {
			ArgumentFactory argument = new ArgumentFactory(args);
			String algorithm = argument.get(ArgumentType.ALGORITHM);
			String mode = argument.get(ArgumentType.MODE);
			String data = argument.get(ArgumentType.DATA);
			String in = argument.get(ArgumentType.IN);
			String out = argument.get(ArgumentType.OUT);
			int key = Integer.parseInt(argument.get(ArgumentType.KEY));

			Encryptor encryptor = createEncryptor(algorithm);
			String textForProcessing = getTextForProcessing(data, in);

			String result = "";
			if ("enc".equals(mode)) {
				result = encryptor.encrypt(textForProcessing, key);
			} else if ("dec".equals(mode)) {
				result = encryptor.decrypt(textForProcessing, key);
			}

			printOutResult(out, result);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static Encryptor createEncryptor(String algorithm) {
		if ("unicode".equals(algorithm)) {
			return new Encryptor(new UnicodeEncryptor());
		}
		return new Encryptor(new ShiftingEncryptor());
	}

	private static String getTextForProcessing(String textAsArgument, String fileNameAsArgument) throws IOException {
		if (textAsArgument.isEmpty() && !fileNameAsArgument.isEmpty()) {
			return readFileAsString(fileNameAsArgument);
		} else {
			return textAsArgument;
		}
	}

	private static void printOutResult(String fileName, String text) throws IOException {
		if (fileName.isEmpty()) {
			System.out.println(text);
		} else {
			writeToFile(fileName, text);
		}
	}

	private static String readFileAsString(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	private static void writeToFile(String filePath, String text) throws IOException {
		File file = new File(filePath);
		try (FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write(text);
		}
	}

}
