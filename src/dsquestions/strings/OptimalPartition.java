package dsquestions.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OptimalPartition {

    public static int partitionString(String s) {

        int res = 0;
        int i=0;
        while (i<s.length()){
            Set<Character>set=new HashSet<>();
            while (i<s.length() && !set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
            }
            res++;
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(partitionString("abacaba"));
    }


}
