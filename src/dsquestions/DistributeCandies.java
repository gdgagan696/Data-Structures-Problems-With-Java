package dsquestions;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

	private static int distributeCandies(int[] candyType) {
		Set<Integer> candiesSet = new HashSet<>();
		for (int candy : candyType) {
			candiesSet.add(candy);
		}
		int maxCandiesToEat = candyType.length / 2;
		int totalCandiesType = candiesSet.size();
		return totalCandiesType >= maxCandiesToEat ? maxCandiesToEat : totalCandiesType;

	}

	public static void main(String[] args) {
		System.err.println(distributeCandies(new int[] { 1, 1, 2, 2, 3, 3 }));
		System.err.println(distributeCandies(new int[] { 1, 1, 2, 3 }));

	}

}
