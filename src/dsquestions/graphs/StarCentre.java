package dsquestions.graphs;

import java.util.HashMap;
import java.util.Map;

public class StarCentre {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> hm=new HashMap<>();
        for (int[]edge:edges){
            hm.put(edge[0],hm.getOrDefault(edge[0],0)+1);
            hm.put(edge[1],hm.getOrDefault(edge[1],0)+1);
            if(hm.get(edge[0])==edge.length){
                return edge[0];
            }
            if(hm.get(edge[1])==edge.length){
                return edge[1];
            }
        }
        int n=hm.size();
        for (int key:hm.keySet()){
            if(hm.get(key)==n-1){
                return key;
            }
        }
        return -1;


    }
}
