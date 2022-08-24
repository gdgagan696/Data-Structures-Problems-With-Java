package dsquestions.maths;

public class PowerOf3 {
    public static boolean isPowerOfThree(int n) {
        if(n==0)return false;
        double x=Math.ceil((Math.log(n)/Math.log(3)));
        long num=(long)Math.pow(3,x);
        return num==n;
    }

    public static void main(String[]args){
        System.out.println(isPowerOfThree(243));
    }
}
