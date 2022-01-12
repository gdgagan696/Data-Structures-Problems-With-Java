package dsquestions.arrays;

public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor=xor^nums[i];
        }
        int count=0;
        int mask=1;
        while (true){
            if((xor&mask)!=0)break;
            mask=mask<<1;
        }
        int first = 0;
        int second = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&mask)!=0){
                first=first^nums[i];
            }
            else{
                second=second^nums[i];
            }
        }
        return first!=0?first:second;


    }

    public static void main(String[]args){
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));

    }
}
