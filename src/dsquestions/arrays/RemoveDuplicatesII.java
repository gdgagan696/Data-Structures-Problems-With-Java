package dsquestions.arrays;

public class RemoveDuplicatesII {
    public static int removeDuplicates(int[] nums) {

        if(nums.length==0 || nums.length==1){
            return nums.length;
        }
        int j=0;
        int count=1;
        int i=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){

                if(count<2){
                    count++;
                    j++;

                }


            }
            else if(nums[i]!=nums[i+1]){
                if(count==2){
                    count=1;
                }
                else{
                    count=1;
                    j++;
                }

            }
        }

        return nums[i-1]==nums[i]?j:++j;


    }

    public static void main(String[]args){
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));


    }
}
