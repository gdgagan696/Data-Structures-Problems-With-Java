package dsquestions;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	private static List<List<Integer>> pascalTriangle1(int rows){
		List<List<Integer>> result=new ArrayList<>();
		if(rows==0)return result;
		result.add(new ArrayList<Integer>());
		result.get(0).add(1);
		for(int i=1;i<rows;i++) {
			List<Integer>tempList=new ArrayList<>();
			tempList.add(1);
			for(int j=1;j<i;j++) {
			tempList.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
			}
			tempList.add(1);
			result.add(tempList);
		}
		return result;
	}
	
	private static List<Integer> pascalTriangle2(int row) {
		
		if(row==0)return new ArrayList<>();
		List<List<Integer>> result=new ArrayList<>();
		result.add(new ArrayList<Integer>());
		result.get(0).add(1);
		for(int i=1;i<row;i++) {
			List<Integer>tempList=new ArrayList<>();
			tempList.add(1);
			for(int j=1;j<i;j++) {
			tempList.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
			}
			tempList.add(1);
			result.add(tempList);
		}
		return result.get(result.size()-1);
		
	}
	public static void main(String[] args) {
		List<List<Integer>> result=pascalTriangle1(5);
		System.out.println(result);
		List<Integer> result1=pascalTriangle2(5);
		System.out.println(result1);

	}

}
