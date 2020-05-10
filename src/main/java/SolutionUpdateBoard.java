public class SolutionUpdateBoard {

  public char[][] updateBoard(char[][] board, int[] click) {
    int m = board.length;
    int n = board[0].length;

    Queue<int[]> queue = new LinkedList<>();
    queue.add(click);
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int row = cell[0];
      int col = cell[1];

      if (board[row][col] == 'M') {
        board[row][col] = 'X';
        break;
      } else {
        int count = 0;
        for (int i = -1; i < 2; i++) {
          for (int j = -1; j < 2; j++) {
            if (i == 0 && j == 0) {
              continue;
            }
            int r = row + i;
            int c = col + j;
            if (r < 0 || r >= m || c < 0 || c >= n) {
              continue;
            }
            if (board[r][c] == 'M' || board[r][c] == 'X') {
              count++;
            }
          }
        }
        if (count > 0) {
          board[row][col] = (char) (count + '0');
        } else {
          //BFS
          board[row][col] = 'B';
          for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
              if (i == 0 && j == 0) {
                continue;
              }
              int r = row + i;
              int c = col + j;
              if (r < 0 || r >= m || c < 0 || c >= n) {
                continue;
              }
              if (board[r][c] == 'E') {
                queue.add(new int[]{r, c});
                board[r][c] = 'B';
              }
            }
          }
        }
      }
    }
    return board;
  }
}
