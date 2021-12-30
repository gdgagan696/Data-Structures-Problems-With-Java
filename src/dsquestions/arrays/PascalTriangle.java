package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        if(numRows==0){
            result.add(new ArrayList<>());
            return  result;
        }
        List<Integer>firstRow=new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        for(int i=1;i<numRows;i++){
            List<Integer>ithRow=new ArrayList<>();
            ithRow.add(1);
            for(int j=1;j<i;j++){
                int val=result.get(i-1).get(j)+result.get(i-1).get(j-1);
                ithRow.add(val);
            }
            ithRow.add(1);
            result.add(ithRow);
        }
        return  result;

    }

    public static void main(String[]args){
        System.out.println(generate(5));
    }
}
