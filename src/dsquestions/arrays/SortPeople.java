//package dsquestions.arrays;
//
//import javafx.util.Pair;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class SortPeople {
//    public String[] sortPeople(String[] names, int[] heights) {
//        List<Pair<Integer,String>>list=new ArrayList<>();
//        for (int i=0;i<names.length;i++){
//            list.add(new Pair<>(heights[i],names[i]));
//        }
//        list.sort((a,b)->b.getKey()-a.getKey());
//        return list.stream()
//                .map(Pair::getValue)
//                .toArray(String[]::new);
//    }
//}
