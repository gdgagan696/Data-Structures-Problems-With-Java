package dsquestions;

public class SudokoSolver {

	private boolean canPlaceNum(int[][] board, int row, int col, int num) {
		if (!isRowSafe(board, row, num)) {
			return false;
		}
		if (!isColSafe(board, col, num)) {
			return false;
		}
		if (!isBoxSafe(board, row, col, num)) {
			return false;
		}
		return true;
	}

	private boolean isRowSafe(int[][] board, int row, int num) {
		for (int j = 0; j < board[row].length; j++) {
			if (board[row][j] == num) {
				return false;
			}
		}
		return true;
	}

	private boolean isColSafe(int[][] board, int col, int num) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num) {
				return false;
			}
		}
		return true;
	}

	private boolean isBoxSafe(int[][] board, int row, int col, int num) {
		int n = board.length;
		int divisionfactor = (int) Math.sqrt(n);
		int rowStart = row - row % divisionfactor;
		int colStart = col - col % divisionfactor;
		for (int i = rowStart; i < rowStart + divisionfactor; i++) {
			for (int j = colStart; j < colStart + divisionfactor; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean sudokoSolver(int[][] board) {
		int n = board.length;
		int row = -1;
		int col = -1;
		boolean isEmpty = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					isEmpty = true;
					row = i;
					col = j;
					break;
				}
			}
			if (isEmpty) {
				break;
			}
		}
		if (!isEmpty) {
			return true;
		}
		for (int num = 1; num <= n; num++) {
			if (canPlaceNum(board, row, col, num)) {
				board[row][col] = num;
				if (sudokoSolver(board)) {
					return true;
				}
				board[row][col] = 0;
			}
		}
		return false;

	}

	public static void main(String[] args) {

		SudokoSolver sudokoSolver = new SudokoSolver();
//		int board[][]={
//				{1,3,0,4},
//				{2,0,3,1},
//				{0,1,0,2},
//				{4,0,1,0}
//				};
		int[][] board = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		System.out.println(sudokoSolver.sudokoSolver(board));
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

}
