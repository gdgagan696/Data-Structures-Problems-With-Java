package dsquestions;

import java.util.Arrays;

public class CandyProblem {

	private static int[] distributeCandy(int candies,int people) {
		int result[]=new int[people];
		int candy=1;
		int i=0;
		while(candy<=candies) {
			if(i==people)i=0;
			result[i]+=candy;
			candies-=candy;
			candy++;
			i++;
		}
		if(candies>0) {
			if(i==people)i=0;
			result[i]+=candies;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(distributeCandy(7, 4)));
		
	}
}
