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

    static boolean isNeighbour(char[] sentence, int index) {
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
            result += isNeighbour(arr, i) ? 1 : 0;
        }
        return result;
    }

    public static String swapLetters(String str, int i, int j) {
        if (str.length() <= i || str.length() <= j) {
            throw new ArrayIndexOutOfBoundsException("Wrong position of letters");
        }
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    public static void main(String[] args) {
        final String string = "abcd_efg";
        final int k = 2;

        try {
            System.out.println(getStringSymbol(string, 2)); //third letter
            System.out.println(getStringSymbol(string, string.length() - 1)); // last letter
            System.out.println(getStringSymbol(string, k - 1)); // k-th letter
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(countEqualNeighbouringLetters("aaa  bb  cc"));
        System.out.println(swapLetters(string, 1, 4));
    }
}
