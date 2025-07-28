package dsquestions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int rottenOrange(int[][] grid) {

		Queue<Pair> queue = new LinkedList<>();
		int total = 0, rotten = 0, time = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 || grid[i][j]==2) {
					total++;
				}
				if (grid[i][j] == 2) {
					queue.offer(new Pair(i, j));
				}
			}
		}

		if (total == 0) {
			return 0;
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			rotten += size;
			if (rotten == total) {
				return time;
			}
			time++;

			for (int i = 0; i < size; i++) {
				Pair temp = queue.poll();
				if (temp.y + 1 < grid[0].length && grid[temp.x][temp.y + 1] == 1) {
					grid[temp.x][temp.y + 1] = 2;
					queue.offer(new Pair(temp.x, temp.y + 1));
				}
				if (temp.y - 1 >= 0 && grid[temp.x][temp.y - 1] == 1) {
					grid[temp.x][temp.y - 1] = 2;
					queue.offer(new Pair(temp.x, temp.y - 1));
				}
				if (temp.x + 1 < grid.length && grid[temp.x + 1][temp.y] == 1) {
					grid[temp.x + 1][temp.y] = 2;
					queue.offer(new Pair(temp.x + 1, temp.y));
				}
				if (temp.x - 1 >= 0 && grid[temp.x - 1][temp.y] == 1) {
					grid[temp.x - 1][temp.y] = 2;
					queue.offer(new Pair(temp.x - 1, temp.y));
				}
			}

		}
		return -1;

	}

	public static void main(String[] args) {
		int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(rottenOrange(grid));

	}

}
