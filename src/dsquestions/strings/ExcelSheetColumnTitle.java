package dsquestions.strings;

public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            char ch = (char) ((columnNumber - 1) % 26 + 'A');
            result.append(ch);
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
