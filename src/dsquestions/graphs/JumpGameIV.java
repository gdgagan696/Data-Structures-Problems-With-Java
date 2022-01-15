package dsquestions.graphs;

import java.util.*;

public class JumpGameIV {
    public static int minJumps_DFS(int[] arr) {

        if(arr==null || arr.length==1)return 0;

        Map<Integer, List<Integer>> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            List<Integer>temp=new ArrayList<>();
            if(i+1<arr.length)temp.add(i+1);
            if(i-1>=0)temp.add(i-1);
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    temp.add(j);
                }
            }
            hm.put(i,temp);
        }
        
        int dp[]=new int[arr.length];
        boolean visited[]=new boolean[arr.length];
        Arrays.fill(dp,-1);
        return minJumps_DFS(arr,hm,0,dp,visited);
    }

    /*
    Gives TLE
     */
    private static int minJumps_DFS(int[] arr, Map<Integer, List<Integer>> hm, int i, int[] dp,boolean[]visited) {
        if(i>=arr.length-1)return 0;

        if(dp[i]!=-1)return dp[i];
        visited[i]=true;
        int min=Integer.MAX_VALUE;

        List<Integer>neighbour=hm.get(i);
        for(int x:neighbour){
            if(!visited[x]) {
                int temp = minJumps_DFS(arr, hm, x, dp, visited);
                if (temp >= 0 && temp < min) {
                    min = 1+temp;
                }
            }
        }
        arr[i]=min==Integer.MAX_VALUE?-1:min;
        visited[i]=false;
        return min;
    }
    public static int minJumps_BFS(int[] arr) {

        if(arr==null || arr.length==1)return 0;

        Map<Integer, List<Integer>> hm=new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        }

        Queue<Integer>queue=new LinkedList<>();
        int dis=0;
        boolean visited[]=new boolean[arr.length];
        queue.add(0);
        visited[0]=true;
        while (queue.size()>0){
            int size=queue.size();
            for(int j=0;j<size;j++) {
                int i = queue.poll();
                if (i == arr.length - 1) {
                    return dis;
                }
                List<Integer> neighbour = hm.getOrDefault(arr[i],new ArrayList<>());
                neighbour.add(i-1);
                neighbour.add(i+1);
                for (int x : neighbour) {
                    if (x>=0 && x<arr.length && !visited[x]) {
                        queue.add(x);
                        visited[x] = true;
                    }
                }
                hm.remove(arr[i]);
            }
            dis++;
        }
        return dis;
    }

    public static void main(String[]args){
        System.out.println(minJumps_BFS(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
        System.out.println(minJumps_BFS(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
    }
}
