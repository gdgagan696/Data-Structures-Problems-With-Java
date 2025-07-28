package dsquestions.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestOrigin {

    class Pair{
        int val;
        int x;
        int y;
        Pair(int val,int x,int y){
            this.val=val;
            this.x=x;
            this.y=y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->b.val-a.val);
        int [][]res=new int[k][2];
        for(int []point:points){
            int val=point[0]*point[0]+point[1]*point[1];
            if(pq.size()<k){
                pq.add(new Pair(val,point[0],point[1]));
            }
            else if(pq.peek().val>val){
                pq.poll();
                pq.add(new Pair(val,point[0],point[1]));
            }
        }
        int i=0;
        while (pq.size()>0){
            Pair pair=pq.poll();
            res[i][0]=pair.x;
            res[i][1]=pair.y;
            i++;
        }
        return res;
    }
    public static void main(String[]args){
        KClosestOrigin kClosestOrigin=new KClosestOrigin();
        int points[][]={{1,3},{-2,2}};
        System.out.println(Arrays.toString(kClosestOrigin.kClosest(points,1)));

    }
}
