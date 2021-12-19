package dsquestions.arrays;

public class LargestAltitude {
    public static int largestAltitude(int[] gain) {
        int max=Integer.MIN_VALUE;
        int curr=0;
        for(int i=0;i<gain.length;i++){
            curr+=gain[i];
            max=Math.max(curr,max);
        }
        return max;
    }

    public static void main(String []args){
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
    }
}
