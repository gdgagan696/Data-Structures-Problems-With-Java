package dsquestions.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DestinationCity {


    public static String destCity(List<List<String>> paths) {
        HashSet<String> hashSet = new HashSet<>();
        for (List<String> path : paths) {
            hashSet.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!hashSet.contains(path.get(1)))
                return path.get(1);
        }

        return null;

    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("A", "Z"));
        System.out.println(destCity(paths));

    }
}
