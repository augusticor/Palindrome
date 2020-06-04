package logic;

import java.util.Scanner;

/**
 * PALINDROME: This is a competitive programming exercise.
 * Used I.D.E: Eclipse
 * Language: Java
 * @author augusticor
 * @version 1.1
 */
public class Palindrome {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		final String REGEX = "\\W|_";

		System.out.println("Please write the word you wanna know if is palindrome");
		String word = scanner.nextLine();
		word = word.toLowerCase();
		word = removeAccents(word);
		word = word.replaceAll(REGEX, "");

		String reversedWord = reverseWord(word);
		int coincidences = countCharacterCoincidences(word, reversedWord);

		System.out.println(word.equals(reversedWord) ? "The entered chain is a palindrome"
				: "The entered chain is NOT a palindrome -  " + coincidences);

		scanner.close();
	}

	public static String removeAccents(String word) {
		word = word.replace('á', 'a');
		word = word.replace('é', 'e');
		word = word.replace('í', 'i');
		word = word.replace('ó', 'o');
		word = word.replace('ú', 'u');
		word = word.replace('ñ', 'n');
		return word;
	}

	public static String reverseWord(String word) {
		String reverseWord = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			reverseWord += word.charAt(i);
		}
		return reverseWord;
	}

	public static int countCharacterCoincidences(String word, String reversedWord) {
		int coincidences = 0;
		for (int j = 0; j < word.length(); j++) {
			if (word.charAt(j) == reversedWord.charAt(j)) {
				coincidences++;
			} else
				break;
		}
		return coincidences;
	}
}