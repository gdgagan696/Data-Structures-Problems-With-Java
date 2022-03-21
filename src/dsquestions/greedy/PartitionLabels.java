package dsquestions.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {

        int lastIndex[] = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }
        int previousPartitionEnd = -1;
        int maxPartitionLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            maxPartitionLen = Math.max(maxPartitionLen, lastIndex[ch - 'a']);
            if (maxPartitionLen == i) {
                result.add(maxPartitionLen - previousPartitionEnd);
                previousPartitionEnd = maxPartitionLen;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
