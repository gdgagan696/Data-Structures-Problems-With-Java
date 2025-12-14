package dsquestions.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {

        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        List<Integer>result=new ArrayList<>();
        Set<Character>set=new HashSet<>();
        List<Character>temp=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            temp.add(ch);
            hm.put(ch,hm.get(ch)-1);
            set.add(ch);
            if(hm.get(ch)==0){
                hm.remove(ch);
                set.remove(ch);
            }
            if(set.size()==0){
                result.add(temp.size());
                temp.clear();
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(partitionLabels("eccbbbbdec"));

    }

}
