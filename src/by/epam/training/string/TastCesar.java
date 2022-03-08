package by.epam.training.string;

public class TastCesar {

	public static void main(String[] args) {

		String encodedString = "MVEZ MZUZ MZTZ";

		// определила в процессе решения)
		String decodedString = "VENI VIDI VICI";

		int shiftIndex = 0;

		boolean control = false;

		for (int i = 1; i < 26; i++) {

			char[] array = generateShiftedArray(encodedString, i);

			control = control(array, decodedString);

			if (control) {

				shiftIndex = i;
			}
			// надо для вывода промежуточного результата
			printShiftedArray(array, i);
		}

		printResult(shiftIndex);

	}

	public static char[] generateShiftedArray(String str, int index) {

		char ch;

		char[] array = str.toCharArray();

		for (int j = 0; j < array.length; j++) {

			if (array[j] == '\u0020') {

				continue;
			}
			int digitCode = (int) array[j];

			digitCode += index;

			ch = (char) digitCode;

			if (ch > 'Z') {

				int ind = (int) 'Z' - array[j];

				digitCode = ((int) 'A') + (index - 1) - ind;

			}

			array[j] = (char) digitCode;

		}
		return array;
	}

	public static void printShiftedArray(char[] array, int index) {

		String str = new String(array);

		System.out.println(str + " < Индекс сдвига - " + index + " >");
	}

	public static void printResult(int shiftIndex) {

		System.out.println("Ключ шифра сдвига данного высказывания - " + shiftIndex + "!");
	}

	public static boolean control(char[] encodedArray, String decoded) {

		boolean equal;

		String str = new String(encodedArray);

		if (str.equals(decoded)) {
			equal = true;
		} else {
			equal = false;
		}

		return equal;

	}

}
