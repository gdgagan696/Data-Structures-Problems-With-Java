package dsquestions.arrays;

public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        long i=0;
        long j= (long) Math.sqrt(c);
        while (i<=j){
            long mid=i*i+j*j;
            if(mid==c){
                return true;
            }
            else if(mid>c){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1000000));
    }

}
