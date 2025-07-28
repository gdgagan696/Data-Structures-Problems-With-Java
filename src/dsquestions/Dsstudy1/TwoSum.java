package dsquestions.Dsstudy1;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {

        int res[]=new int[2];
        int i=0,j=numbers.length-1;
        while (i<j){
            int sum=numbers[i]+numbers[j];
            if(sum==target){
                res[0]=i;
                res[1]=j;
            }
            else if(sum>target){
                j--;
            }
            else {
                i++;
            }
        }
        return res;

    }
}
