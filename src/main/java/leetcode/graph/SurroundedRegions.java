package leetcode.graph;

import java.util.LinkedList;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example, X X X X X O O X X X O X X O X X
 * 
 * After running your function, the board should be:
 * 
 * X X X X X X X X X X X X X O X X
 * 
 */

public class SurroundedRegions {

	// **Very Important:
	// The key is to mark as visited before adding to queue

	// O(m*n), O(m*n) space
	public void solve(char[][] board) {

		if (board == null || board.length == 0 || board[0].length == 0) // CHECK THIS!
			return;

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) { // write indices according to the dimensions
			floodFill(board, i, 0);
			floodFill(board, i, n - 1);
		}

		for (int j = 0; j < n; j++) {
			floodFill(board, 0, j);
			floodFill(board, m - 1, j);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'G')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	private boolean isValid(char[][] board, int x, int y) {
		return (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O');
	}

	private void floodFill(char[][] board, int x, int y) {

		int m = board.length;
		int n = board[0].length;

		if (isValid(board, x, y)) {
			LinkedList<Integer> queue = new LinkedList<>(); // Don't need visited, use to board!
			int cord = x * n + y;

			board[x][y] = 'G'; // THIS IS IMPORTANT
			queue.add(cord);
			while (!queue.isEmpty()) {
				cord = queue.pop();
				x = cord / n; // TAKE A LOOK AT THE INDICES HERE
				y = cord % n;

				if (isValid(board, x + 1, y)) {
					queue.add((x + 1) * m + y);
					board[x + 1][y] = 'G';
				}

				if (isValid(board, x - 1, y)) {
					queue.add((x - 1) * m + y);
					board[x - 1][y] = 'G';
				}

				if (isValid(board, x, y + 1)) {
					queue.add(x * m + (y + 1));
					board[x][y + 1] = 'G';
				}

				if (isValid(board, x, y - 1)) {
					queue.add(x * m + (y - 1));
					board[x][y - 1] = 'G';
				}
			}
		}
	}
}
