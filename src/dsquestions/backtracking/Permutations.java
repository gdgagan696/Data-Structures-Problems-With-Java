package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        boolean[]visited=new boolean[nums.length];
        permute(nums,temp,result,visited);
        return result;
    }

    private static void permute(int[] nums, List<Integer>temp, List<List<Integer>> result,boolean[]visited) {
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                temp.add(nums[i]);
                visited[i]=true;
                permute(nums,temp,result,visited);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[]args){
        System.out.println(permute(new int[]{1,2,3}));
    }

}
