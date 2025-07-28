package dsquestions.revision;

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s1=new Stack<>();
        int n=heights.length;
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=-1;
        right[n-1]=n;
        s1.push(0);
        for(int i=1;i<n;i++){
            while(s1.size()>0 && heights[i]<heights[s1.peek()]){
                s1.pop();
            }
            if(s1.size()==0){
                left[i]=-1;
            }
            else{
                left[i]=s1.peek();
            }
            s1.push(i);
        }
        s1.clear();
        s1.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(s1.size()>0 && heights[i]<heights[s1.peek()]){
                s1.pop();
            }
            if(s1.size()==0){
                right[i]=n;
            }
            else{
                right[i]=s1.peek();
            }
            s1.push(i);
        }
        int area=0;
        for(int i=0;i<n;i++){
            int w=right[i]-left[i]-1;
            int h=heights[i];
            area=Math.max(area,w*h);
        }
        return area;

    }

    public static void main(String[]args){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{1,1}));

    }
}
