package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetsRevision {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        subsetsUtil(nums,0,new ArrayList<>(),result);
        return result;
    }

    private void subsetsUtil(int[] nums, int i, List<Integer> current, List<List<Integer>> result) {
        if(i>=nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        subsetsUtil(nums,i+1,current,result);
        current.remove(current.size()-1);
        subsetsUtil(nums,i+1,current,result);
    }
}
