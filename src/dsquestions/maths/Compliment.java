package dsquestions.maths;

public class Compliment {
    public static int findComplement(int num) {
        char [] binary=Integer.toBinaryString(num).toCharArray();
        for (int i=0;i<binary.length;i++){
            binary[i]=binary[i]=='0'?'1':'0';
        }
        return Integer.parseInt(new String(binary),2);
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
