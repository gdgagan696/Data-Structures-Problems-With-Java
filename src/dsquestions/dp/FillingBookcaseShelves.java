package dsquestions.dp;

import java.util.HashMap;
import java.util.Map;

public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Map<String,Integer> dp=new HashMap<>();
        return minHeightShelvesUtil(books,shelfWidth,0,shelfWidth,0,dp);

    }
    public int minHeightShelvesUtil(int [][]books, int shelfWidth, int index, int currentWidth, int maxHeight,Map<String,Integer>dp){
        if(index>=books.length){
            return maxHeight;
        }
        String key=index+"-"+currentWidth;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int w=books[index][0];
        int h=books[index][1];
        int op1=Integer.MAX_VALUE;
        if(currentWidth>=w){
            op1= minHeightShelvesUtil(books,shelfWidth,index+1,currentWidth-w,Math.max(maxHeight,h),dp);
        }
        int op2=maxHeight+ minHeightShelvesUtil(books,shelfWidth,index+1,shelfWidth-w,h,dp);
        dp.put(key,Math.min(op1,op2));
        return dp.get(key);

    }
}
