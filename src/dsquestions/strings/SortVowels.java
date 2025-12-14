package dsquestions.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SortVowels {
    public static String sortVowels(String s) {
        List<Character> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        Set<Character>vowels= Set.of('a','e','i','o','u','A','E','I','O','U');
        for(char ch:s.toCharArray()){
            if(vowels.contains(ch)){
                list.add(ch);
            }
        }
        Collections.sort(list);
        int i=0;
        for (char ch:s.toCharArray()){
            if(vowels.contains(ch)) {
                sb.append(list.get(i++));
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(sortVowels("lEetcOde"));
    }

}
