package dsquestions.maths;

public class MaximumSixtyNineNumber {
    public static int maximum69Number(int num) {
        char temp[] = String.valueOf(num).toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '6') {
                temp[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(temp));
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }
}
