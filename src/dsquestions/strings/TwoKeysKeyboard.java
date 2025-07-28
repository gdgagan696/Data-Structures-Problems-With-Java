package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class TwoKeysKeyboard {
    public static int minSteps(int n) {
        if(n==1){
            return 0;
        }
        Map<String,Integer> dp=new HashMap<>();
        return minStepsUtil(n,"A","A",dp)+1;

    }

    private static int minStepsUtil(int n, String current, String copy,  Map<String,Integer> dp) {
        if(current.length() == n){
            return 0;
        }
        if(current.length() > n){
            return 2000;
        }
        String key=current+"_"+copy;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int op1 = 1 + minStepsUtil(n, current + copy, copy,dp);
        int op2 = 2+minStepsUtil(n,current+current,current,dp);
        dp.put(key,Math.min(op1,op2));
        return Math.min(op1,op2);
    }

    public static void main(String[] args) {

        System.out.println(minSteps(3));
    }

}
