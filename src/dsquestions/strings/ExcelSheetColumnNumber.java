package dsquestions.strings;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String columnTitle) {
        int res = 0;
        for (char ch : columnTitle.toCharArray()) {
            res = res * 26 + (ch - 'A') + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
