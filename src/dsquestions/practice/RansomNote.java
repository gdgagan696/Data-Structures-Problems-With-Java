package dsquestions.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> hm = new HashMap<>();
        for(int i= 0 ; i< magazine.length() ; i++) {
            char ch=magazine.charAt(i);
            hm.computeIfPresent(ch, (c,count)-> count+1);
            hm.putIfAbsent(ch, 1);
        }
        for (char ch:ransomNote.toCharArray()){
            if(hm.containsKey(ch) && hm.get(ch)>0){
                hm.computeIfPresent(ch,(c,count)->count-1);
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa","aab"));
    }
}
