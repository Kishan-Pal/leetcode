class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(!isValidRows(board)) return false;
        if(!isValidCols(board)) return false;
        return isValidAllGrids(board);
    }

    public boolean isValidRows(char[][] board) {
        for(int i=0; i<9; i++) {
            HashSet<Character> hash = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.' && hash.contains(board[i][j])) return false;
                else hash.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidCols(char[][] board) {
        for(int i=0; i<9; i++) {
            HashSet<Character> hash = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[j][i] != '.' && hash.contains(board[j][i])) return false;
                else hash.add(board[j][i]);
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
        HashSet<Character> hash = new HashSet<>();
        for(int i=centeri-1; i<=centeri+1; i++) {
            for(int j=centerj-1; j<=centerj+1; j++) {
                if(board[i][j] != '.' && hash.contains(board[i][j])) return false;
                else hash.add(board[i][j]);
            }
        }
        return true;
    }
}