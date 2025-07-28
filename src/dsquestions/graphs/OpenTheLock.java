package dsquestions.graphs;

import java.util.*;
import java.util.stream.Collectors;

public class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{"0000","0"});
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Set<String> deadendsSet = Arrays.stream(deadends).collect(Collectors.toSet());
        if(deadendsSet.contains("0000")){
            return -1;
        }
        while (!queue.isEmpty()) {
            String [] temp = queue.poll();
            String current = temp[0];
            int steps=Integer.parseInt(temp[1]);
            if (temp[0].equals(target)) {
                return steps;
            }
            for (int i = 0; i < 4; i++) {
                char[] arr = current.toCharArray();
                char ch = arr[i];
                if (ch == '9') {
                    arr[i] = '0';
                } else {
                    arr[i] = (char) (ch + 1);
                }
                String str1 = new String(arr);
                if (!visited.contains(str1) && !deadendsSet.contains(str1)) {
                    visited.add(str1);
                    queue.add(new String[]{str1,steps+1+""});
                }
                if (ch == '0') {
                    arr[i] = '9';
                } else {
                    arr[i] = (char) (ch - 1);
                }
                String str2 = new String(arr);
                if (!visited.contains(str2) && !deadendsSet.contains(str2)) {
                    visited.add(str2);
                    queue.add(new String[]{str2,steps+1+""});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(deadends, "0202"));
    }
}
