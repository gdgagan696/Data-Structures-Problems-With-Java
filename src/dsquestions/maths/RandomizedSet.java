package dsquestions.maths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomizedSet {
    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(set);

        int randomIdx = (int) (Math.random() * set.size());
        return list.get(randomIdx);
    }
}
