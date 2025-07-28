package dsquestions;

import java.util.ArrayList;
import java.util.List;

/*Values in array is less than equal to Array Length.*/

public class ArrayDuplicates {

	private static List<Integer> findDuplicates(int [] arr){
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(arr[Math.abs(arr[i])]>0) {
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			}
			else {
				result.add(Math.abs(arr[i]));
			}
		}
		return result;
	}
	
	public static void main(String [] args) {
		 int arr[] = {1, 2, 3, 1, 3, 6, 6}; 
	      List<Integer> duplicates=findDuplicates(arr);
	      for (int a : duplicates) {
			System.out.println(a);
		}
		
	}
}
