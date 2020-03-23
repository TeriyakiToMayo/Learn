
public class Num79_WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][][] boards = {
				{
					{'A','B','C','E'},
					{'S','F','C','S'},
					{'A','D','E','E'},
				},
				
				{
					{'a', 'a'},
				}
		};
		
		String[][] strses = {
				{
					"ABCCED",	//true
					"SEE",			//true
					"ABCB",		//false
				},
				
				{
					"aaa",			//false
				},
		};
		
		for(int i = 0; i < boards.length; i++) {
			for(String str : strses[i]) {
				char[][] board = copyBoard(boards[i]);
				IO.outMain(str + " " + exist(board, str));
			}
		}
		
		IO.outMain(strses[0][0] + " " + exist(boards[0].clone(), strses[0][0]));

	}
	
	public static char[][] copyBoard(char[][] board){
		char[][] newBoard = new char[board.length][board[0].length];
		
		for(int i = 0; i < board.length; i++) {
			newBoard[i] = board[i].clone();
		}
		return newBoard;
	}
	
	
	//=======================================================
	// Solution 2
	//=======================================================
	private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;
    private int n;
    private String word;
    private char[][] board;

    public boolean exist2(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

	
	
	//=======================================================
	// Solution 1
	//=======================================================
	public static int[] Xes = {0, 1, 0, -1};
	public static int[] Yes = {-1, 0, 1, 0};
	public static char[][] Board;
	public static String Word;
	public static int row = 0, col = 0;
	
	public static boolean exist(char[][] board, String word) {
		if(board.length == 0 || board[0].length == 0 || word.length() == 0) return false;
		
		Board = board;
		Word = word;
		row = board.length;
		col = board[0].length;
		
		char c = word.charAt(0);
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(Board[i][j] == c) {
					Board[i][j] = '0';
					if(helper(j, i, 1)) return true;
					Board[i][j] = c;
				}
			}
		}
		return false;
    }
	
	public static boolean helper(int x, int y, int start) {
		if(start == Word.length()) return true;
		
		char c = Word.charAt(start);
		for(int i = 0; i < 4; i++) {
			int nextX = Xes[i] + x;
			int nextY = Yes[i] + y;
			
			if(nextX < 0 || nextX >= col || nextY < 0 || nextY >= row) continue;
			if(Board[nextY][nextX] == c) {
				Board[nextY][nextX] = '0';
				if(helper(nextX, nextY, start +1)) return true;
				Board[nextY][nextX] = c;
			}
		}
		return false;
	}
	
}
