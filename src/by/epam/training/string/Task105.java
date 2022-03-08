package by.epam.training.string;

import java.util.Scanner;

public class Task105 {
	
	public static void main(String[] args) {

		String crypto;
		crypto = readFromConsole();

		// это надо для проверки, четная или нечетная строка, и корректного вывода результата
		boolean odd;
		odd = control(crypto);

		String encryptedText = getEncryptedText(crypto);
		String decryptedText = getDecryptedText(encryptedText, odd);

		printResult(encryptedText, decryptedText);

	}

	public static boolean control(String crypto) {

		boolean odd;

		if (crypto.length() % 2 != 0) {
			odd = true;
		} else {
			odd = false;
		}
		return odd;
	}

	public static String readFromConsole() {

		System.out.print("Введите текст для шифрования >");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		System.out.println(" Введеный текст: " + s);

		return s;
	}

	public static String getFirstSubstring(String crypto) {

		String s1;
		
		boolean odd = control(crypto);

		if (!odd) {
			s1 = crypto.substring(0, (crypto.length() / 2));
		} else {
			s1 = crypto.substring(0, (crypto.length() / 2)) + " ";
		}
		return s1;
	}

	public static String getSecondSubstring(String crypto) {

		String s2;

			s2 = crypto.substring(crypto.length() / 2, crypto.length());

		return s2;
	}

	public static String getEncryptedText(String crypto) {

		String s1 = getFirstSubstring(crypto);
		String s2 = getSecondSubstring(crypto);

		char[] array1;
		char[] array2;

		array1 = s1.toCharArray();
		array2 = s2.toCharArray();

		char[] resultArray = new char[array1.length + array2.length];

		for (int i = 1, j = 0; i < resultArray.length && j < array1.length; i += 2, j++) {
			
			resultArray[i] = array1[j];
			resultArray[i - 1] = array2[j];
		}

		String result = new String(resultArray);

		return result;
	}

	public static String getDecryptedText(String encryptedString, boolean odd) {

		char[] encryptedArray = encryptedString.toCharArray();

		char[] decryptedArray = new char[encryptedArray.length];

		for (int i = 0, j = encryptedArray.length / 2; i < encryptedArray.length; i += 2, j++) {

			decryptedArray[j] = encryptedArray[i];
		}
		for (int i = 1, j = 0; i < encryptedArray.length; i += 2, j++) {

			decryptedArray[j] = encryptedArray[i];
		}
		String decryptedString = fix(decryptedArray, odd);

		return decryptedString;
	}

	// скореектировать результат, если строка была нечетная
	
	public static String fix(char[] decryptedArray, boolean odd) {

		String decryptedString;

		if (odd) {

			char[] array = new char[decryptedArray.length - 1];

			for (int i = 0, j = 0; i < array.length; i++, j++) {

				if (i == decryptedArray.length / 2 - 1) {
					j++;
				}

				array[i] = decryptedArray[j];
			}
			decryptedString = new String(array);

		} else {
			decryptedString = new String(decryptedArray);
		}
		return decryptedString;
	}

	public static void printResult(String encryptedText, String decryptedText) {

		System.out.println("Результат шифрования исходного текста методом сэндвича - " + encryptedText);

		System.out.println("Дешифрованный теекст - " + decryptedText);
	}
}




