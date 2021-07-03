package dsquestions.backtracking;

public class CountMatches {

    public static int numberOfMatches(int n) {
        if(n<=1)return 0;
        int total=0;
        if((n&1)==1){
            total+=(n-1)/2+numberOfMatches((n-1)/2+1);
        }
        else{
            total+=n/2+numberOfMatches(n/2);
        }
        return total;
    }
    public static void main(String[]args){
        System.out.println(numberOfMatches(7));
        System.out.println(numberOfMatches(14));

    }
}
