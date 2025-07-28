package dsquestions.dp;

import java.util.Arrays;

public class MinCostTickets {

    public static int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length+1];
        Arrays.fill(dp,-1);
        return mincostTicketsRec(days,costs,0,0,dp);
    }


    public static int mincostTicketsRec(int[] days, int[] costs,int day,int presentPass,int []dp) {
        while (day<days.length && presentPass>=days[day]) {
            day++;
        }
        if(dp[day]!=-1)return dp[day];
        if(day>=days.length)return 0;
        int min=Integer.MAX_VALUE;
        int t1 = costs[0] + mincostTicketsRec(days, costs, day + 1, days[day],dp);
        if(t1<min)min=t1;
        int t2 = costs[1] + mincostTicketsRec(days, costs, day + 1, days[day]+6,dp);
        if(t2<min)min=t2;
        int t3 = costs[2] + mincostTicketsRec(days, costs, day + 1, days[day]+29,dp);
        if(t3<min)min=t3;
        dp[day]=min;
        return min;
    }

    public static void main(String[]args){
//        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15}));
        System.out.println(mincostTickets(new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28},
                new int[]{3,13,45}));
    }
}
