package dsquestions.tries;

import java.util.HashSet;
import java.util.List;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String>hs=new HashSet<>();
        for(String word:dictionary){
            hs.add(word);
        }
        StringBuilder sb=new StringBuilder();
        for(String word:sentence.split(" ")){
            String temp="";
            for(int i=1;i<word.length();i++){
                if(hs.contains(word.substring(0,i))){
                    temp=word.substring(0,i);
                    break;
                }
            }
            if(temp.equals("")){
                temp=word;
            }
            sb.append(temp).append(" ");
        }
        return sb.toString().trim();

    }
}
