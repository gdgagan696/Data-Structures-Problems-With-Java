package dsquestions.arrays;

public class ThirdMax {
    private static int thirdMax(int[] nums) {
    long firstMax=Long.MIN_VALUE;
    long secondMax=Long.MIN_VALUE;
    long thirdMax=Long.MIN_VALUE;
    for(int i=0;i<nums.length;i++){
        int x=nums[i];
        if(x>firstMax){
            thirdMax=secondMax;
            secondMax=firstMax;
            firstMax=x;
        }
        else if(x>secondMax && x!=firstMax){
            thirdMax=secondMax;
            secondMax=x;
        }
        else if(x>thirdMax && x!=secondMax && x!=firstMax){
            thirdMax=x;
        }
    }
    return thirdMax!=Long.MIN_VALUE?(int)thirdMax:(int)firstMax;
    }


    public static void main(String[]args){
        System.out.println(thirdMax(new int[]{1,-2147483648,2}));

    }

}
