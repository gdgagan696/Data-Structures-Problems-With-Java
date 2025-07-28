package dsquestions.arrays;

public class SpecialArray {
    public static int specialArray(int[] nums) {
        for (int i=1;i<=nums.length;i++){
            int count=0;
            for(int num:nums){
                if(num>=i){
                    count++;
                }
            }
            if(count==i){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,5}));
    }
}
