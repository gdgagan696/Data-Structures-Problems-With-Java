package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class MaxBalloons {

    public static int maxNumberOfBalloons(String text) {
        Map<Character,Integer>hm=new HashMap<>();
        for (char ch:text.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int b=hm.getOrDefault('b',0);
        int a=hm.getOrDefault('a',0);
        int l=hm.getOrDefault('l',0);
        int o=hm.getOrDefault('o',0);
        int n=hm.getOrDefault('n',0);
        return Math.min(b,Math.min(a,Math.min(l/2,Math.min(o/2,n))));

    }

    public static void main(String[]args){
        System.out.println(maxNumberOfBalloons("leetcode"));


    }
}
