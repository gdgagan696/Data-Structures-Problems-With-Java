package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        boolean visited[]=new boolean[n];
        return allPathsSourceTarget(graph,0,0,n-1,new ArrayList<>(),visited,new ArrayList<>());

    }

    public static List<List<Integer>>allPathsSourceTarget(int[][]graph,
        int vertex,int source,int destination,List<Integer>temp,boolean[]visited,List<List<Integer>>result){
        visited[vertex]=true;
        temp.add(vertex);
        if(vertex==destination){
            result.add(new ArrayList<>(temp));
            return result;
        }
        int []children=graph[vertex];
        for(int child:children){
            if(!visited[child]){
                allPathsSourceTarget(graph,child,source,destination,temp,visited,result);
            }
            visited[child]=false;
            temp.remove(temp.size()-1);
        }
        return result;

    }

    public static void main(String[]args){
        int [][]graph={
                {1,2},
                {3},
                {3},
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }
}
