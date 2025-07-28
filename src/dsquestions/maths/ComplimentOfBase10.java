package dsquestions.maths;

public class ComplimentOfBase10 {
    public static int bitwiseComplement(int n) {
        if (n == 0) return 1;
        String binary = binary(n);
        String complimentBinary = complimentBinary(binary);
        return Integer.parseInt(complimentBinary, 2);

    }

    private static String complimentBinary(String binary) {
        char ch[] = binary.toCharArray();
        for (int i = 0; i < binary.length(); i++) {
            ch[i] = binary.charAt(i) == '1' ? '0' : '1';
        }
        return new String(ch);
    }

    private static String binary(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int rem = n % 2;
            n = n / 2;
            result.append(rem);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
    }
}
