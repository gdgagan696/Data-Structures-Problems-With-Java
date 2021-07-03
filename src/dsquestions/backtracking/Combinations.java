package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>result=new ArrayList<>();
        combine(n,k,result,new ArrayList<>(),1);
        return result;
    }

    private static void combine(int n, int k, List<List<Integer>> result, List<Integer>temp,int index) {
        if(temp.size()==k){
            result.add(new ArrayList<>(temp));
        }
        for(;index<=n;index++){
            temp.add(index);
            combine(n,k,result,temp,index+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[]args){
        System.out.println(combine(4,2));

    }
}
