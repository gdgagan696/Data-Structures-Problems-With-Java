package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QueensAttackKing {

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        Set<List<Integer>> set = Arrays.stream(queens)
                .map(arr -> Arrays.asList(arr[0], arr[1]))
                .collect(Collectors.toSet());
        List<List<Integer>> res = new ArrayList<>();
        int kx = king[0];
        int ky = king[1];

        while (ky++ < 8) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        kx = king[0];
        ky = king[1];
        while (ky-- >= 0) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        kx = king[0];
        ky = king[1];
        while (kx++ < 8) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        kx = king[0];
        ky = king[1];
        while (kx-- >= 0) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        kx = king[0];
        ky = king[1];
        while (kx++ < 8 && ky++ < 8) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        kx = king[0];
        ky = king[1];
        while (kx-- >= 0 && ky-- >= 0) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        kx = king[0];
        ky = king[1];
        while (kx++ < 8 && ky-- >= 0) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        kx = king[0];
        ky = king[1];
        while (kx-- >= 0 && ky++ < 8) {
            if (set.contains(Arrays.asList(kx, ky))) {
                res.add(List.of(kx, ky));
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = {0, 0};
        System.out.println(queensAttacktheKing(queens, king));
    }

}
