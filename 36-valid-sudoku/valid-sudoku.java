class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(!isValidRows(board)) return false;
        if(!isValidCols(board)) return false;
        return isValidAllGrids(board);
    }

    public boolean isValidRows(char[][] board) {
        for(int i=0; i<9; i++) {
            int[] hash = new int[256];
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.' && hash[(int)board[i][j]] == 1) return false;
                else hash[(int)board[i][j]] = 1;
            }
        }
        return true;
    }

    public boolean isValidCols(char[][] board) {
        for(int i=0; i<9; i++) {
            int[] hash = new int[256];
            for(int j=0; j<9; j++) {
                if(board[j][i] != '.' && hash[(int)board[j][i]] == 1) return false;
                else hash[(int)board[j][i]] = 1;
            }
        }
        return true;
    }

    public boolean isValidAllGrids(char[][] board) {
        for(int i=1; i<9; i+=3) {
            for(int j=1; j<9; j+=3) {
                if(!isValidGrid(board, i, j)) return false;
            }
        }
        return true;
    }

    public boolean isValidGrid(char[][] board, int centeri, int centerj) {
        int[] hash = new int[256];
        for(int i=centeri-1; i<=centeri+1; i++) {
            for(int j=centerj-1; j<=centerj+1; j++) {
                if(board[i][j] != '.' && hash[(int)board[i][j]] == 1) return false;
                else hash[(int)board[i][j]] = 1;
            }
        }
        return true;
    }
}