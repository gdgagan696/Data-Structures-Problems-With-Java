package dsquestions.arrays;

public class GrumpyOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i=0,j=0;
        int current=0;
        int max=0;
        int satisfaction=0;
        while (j<customers.length){
            if(grumpy[j]==1){
                current+=customers[j];
            }
            else {
                satisfaction+=customers[j];
            }
            if(j-i+1>minutes){
                if(grumpy[i]==1){
                    current-=customers[i];
                }
                i++;
            }
            max=Math.max(current,max);
            j++;
        }
        return satisfaction+max;
    }

    public static void main(String[] args) {
        int []customers = {2,6,6,9};
        int [] grumpy = {0,0,1,1};

        System.out.println(maxSatisfied(customers,grumpy,1));
    }
}
