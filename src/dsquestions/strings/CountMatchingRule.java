package dsquestions.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountMatchingRule {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (items.size() == 0) return 0;
        int count = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type")) {
                if (item.get(0).equals(ruleValue)) count++;
            } else if (ruleKey.equals("color")) {
                if (item.get(1).equals(ruleValue)) count++;
            } else {
                if (item.get(2).equals(ruleValue)) count++;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "lenovo"));
        items.add(Arrays.asList("phone", "gold", "iphone"));
        System.out.println(countMatches(items, "color", "silver"));


    }
}
