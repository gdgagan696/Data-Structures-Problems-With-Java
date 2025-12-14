package dsquestions.strings;

public class Spreadsheet {

    int[][] matrix;

    public Spreadsheet(int rows) {

        matrix = new int[rows][26];

    }

    public void setCell(String cell, int value) {

        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        matrix[row][col] = value;
    }

    public void resetCell(String cell) {

        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        matrix[row][col] = 0;
    }

    public int getValue(String formula) {

        int plusIndex = formula.indexOf('+');
        String s1 = formula.substring(1, plusIndex);
        String s2 = formula.substring(plusIndex + 1);
        int v1;
        int v2;
        if (!isNumeric(s1)) {
            int col1 = s1.charAt(0) - 'A';
            int row1 = Integer.parseInt(s1.substring(1)) - 1;
            v1 = matrix[row1][col1];
        } else {
            v1 = Integer.parseInt(s1);
        }

        if (!isNumeric(s2)) {
            int col2 = s2.charAt(0) - 'A';
            int row2 = Integer.parseInt(s2.substring(1)) - 1;
            v2 = matrix[row2][col2];
        } else {
            v2 = Integer.parseInt(s2);
        }
        return v1 + v2;
    }

    private static boolean isNumeric(String str) {

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        Spreadsheet spreadsheet = new Spreadsheet(3);
        System.out.println(spreadsheet.getValue("=5+7"));
        spreadsheet.setCell("A1", 10);
        System.out.println(spreadsheet.getValue("=A1+6"));
        spreadsheet.setCell("B2", 15);
        System.out.println(spreadsheet.getValue("=A1+B2"));
        spreadsheet.resetCell("A1");
        System.out.println(spreadsheet.getValue("=A1+B2"));
    }

}
