package main.java.task2;

/* 9.13. Дано слово. Вывести на экран его третий символ.
 * 9.14. Дано слово. Вывести на экран его последний символ.
 * 9.15. Дано слово. Вывести на экран его k-й символ.
 * 9.64. Дано предложение. Определить, сколько в нём одинаковых соседних букв.
 * 9.100. Дано слово. Поменять местами его вторую и пятую буквы.
 */
public class StringsUtil {
    public static char getStringSymbol(String word, int position) {
        if (word.length() <= position) {
            throw new ArrayIndexOutOfBoundsException("Wrong position");
        }
        return word.charAt(position);
    }

    static boolean haveNeighbours(char[] sentence, int index) {
        if (!Character.isLetter(sentence[index])) {
            return false;
        }
        if (index == 0) {
            return sentence[index] == sentence[index + 1];
        } else if (index == sentence.length) {
            return sentence[sentence.length - 1] == sentence[sentence.length - 2];
        } else {
            return (sentence[index] == sentence[index - 1]) || (sentence[index] == sentence[index + 1]);
        }
    }

    public static int countEqualNeighbouringLetters(String sentence) {
        int result = 0;
        char[] arr = sentence.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            result += haveNeighbours(arr, i) ? 1 : 0;
        }
        return result;
    }

    public static String swapLetters(String word, int i, int j) {
        if (word.length() <= i || word.length() <= j) {
            throw new ArrayIndexOutOfBoundsException("Wrong position of letters");
        }
        char ch[] = word.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
