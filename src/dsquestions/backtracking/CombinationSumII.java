package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Util(candidates,0,target,new ArrayList<>(),res);
        return res;

    }

    private static void combinationSum2Util(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> res) {
        if(target==0){
            res.add(new ArrayList<>(current));
        }
        for(int i=index;i<candidates.length && target>=candidates[i];i++){
            if(i>index&&candidates[i]==candidates[i-1])continue;
            current.add(candidates[i]);
            combinationSum2Util(candidates,i+1,target-candidates[i],current,res);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates,8));


    }
}
