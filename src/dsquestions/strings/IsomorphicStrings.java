package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean areIsomorphic(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap<Character,Character> hm=new HashMap<>();
        for(int i=0;i<str1.length();i++){
            if(!hm.containsKey(str1.charAt(i))){
                if(hm.containsValue(str2.charAt(i)))return false;
                hm.put(str1.charAt(i),str2.charAt(i));
            }
            else if(hm.get(str1.charAt(i))!=str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[]args){
        System.out.println(areIsomorphic("badc","baba"));
    }
}
