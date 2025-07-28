package dsquestions.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinNumberOfPushes {
    public static int minimumPushes(String word) {
        Map<Character,Integer> hm=new HashMap<>();
        for(char ch:word.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        Map<Character, Integer> sortedMap = hm.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        int factor=1;
        int keys=8;
        int score=0;
        for(Character key:sortedMap.keySet()){
            score+=factor*sortedMap.get(key);
            keys--;
            if(keys==0){
                keys=8;
                factor++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
