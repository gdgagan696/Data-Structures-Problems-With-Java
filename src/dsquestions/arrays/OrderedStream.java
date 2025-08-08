package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    String[] arr;
    int i;
    int n;

    public OrderedStream(int n) {

        arr = new String[n];
        i = 0;
        this.n = n;

    }

    public List<String> insert(int idKey, String value) {

        List<String> res = new ArrayList<>();
        arr[idKey - 1] = value;
        if (arr[i] != null) {
            for (int start = i; start < n; start++) {
                if (arr[start] == null) {
                    break;
                }
                res.add(arr[start]);
            }
        }
        if (idKey - 1 == i) {
            while (i < n && arr[i] != null) {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // Inserts (3, "ccccc"), returns [].
        System.out.println(os.insert(1, "aaaaa")); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        System.out.println(os.insert(2, "bbbbb")); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        System.out.println(os.insert(5, "eeeee")); // Inserts (5, "eeeee"), returns [].
        System.out.println(os.insert(4, "ddddd")); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
    }

}
