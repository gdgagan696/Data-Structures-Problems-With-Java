package dsquestions.practice;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int res = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if (sum < k) {
                j++;
            } else if (sum == k) {
                res++;
                j++;
            } else {
                while (sum > k) {
                    sum -= nums[i];
                    if(sum==k)res++;
                    i++;
                }
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}

