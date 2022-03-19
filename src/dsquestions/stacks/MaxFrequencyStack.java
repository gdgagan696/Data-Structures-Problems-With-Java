package dsquestions.stacks;

import java.util.*;

public class MaxFrequencyStack {

    Map<Integer, Integer> frequencyMap;
    Map<Integer, Stack<Integer>> frequencyStackMap;
    int maxFreq;

    public MaxFrequencyStack() {
        frequencyStackMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int currentFreq = frequencyMap.getOrDefault(val, 0) + 1;
        frequencyMap.put(val, currentFreq);
        maxFreq = Math.max(maxFreq, currentFreq);
        if (frequencyStackMap.containsKey(currentFreq)) {
            frequencyStackMap.get(currentFreq).push(val);
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            frequencyStackMap.put(currentFreq, stack);
        }

    }

    public int pop() {
        int res = frequencyStackMap.get(maxFreq).pop();
        frequencyMap.put(res, frequencyMap.get(res) - 1);
        if (frequencyStackMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return res;
    }


    public static void main(String[] args) {
        MaxFrequencyStack stack = new MaxFrequencyStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
