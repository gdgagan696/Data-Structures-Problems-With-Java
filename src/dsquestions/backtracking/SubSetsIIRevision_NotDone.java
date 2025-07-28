package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetsIIRevision_NotDone {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        Set<List<Integer>> visited=new HashSet<>();
        subsetsUtil(nums,0,new ArrayList<>(),result,visited);
        return result;
    }

    private void subsetsUtil(int[] nums, int i, List<Integer> current, List<List<Integer>> result,Set<List<Integer>> visited) {
        if(i>=nums.length && !visited.contains(current)){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[i]);
        subsetsUtil(nums,i+1,current,result,visited);
        current.remove(current.size()-1);
        subsetsUtil(nums,i+1,current,result,visited);
    }
}
