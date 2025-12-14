package dsquestions.strings;

public class DateToBinary {

    public static String convertDateToBinary(String date) {

        String[] dateArr = date.split("-");
        StringBuilder stringBuilder = new StringBuilder();
        for (String arr : dateArr) {
            String binary = Integer.toBinaryString(Integer.parseInt(arr));
            stringBuilder.append(binary).append("-");

        }
        return stringBuilder.substring(0,stringBuilder.length()-1).toString();

    }

    public static void main(String[] args) {

        System.out.println(convertDateToBinary("2080-02-29"));

    }

}
