class Solution {
    public void gameOfLife(int[][] board) {
        int[][] original = new int[board.length][board[0].length];
        for(int i=0; i<original.length; i++) {
            for(int j=0; j<original[0].length; j++) {
                original[i][j] = board[i][j];
            }
        }
        for(int i=0; i<original.length; i++) {
            for(int j=0; j<original[0].length; j++) {
                int liveNeighbor = getLiveNeighbor(original, i, j);
                if(original[i][j] == 1) {
                    if(liveNeighbor < 2 || liveNeighbor > 3) {
                        board[i][j] = 0;
                    }
                    else {
                        board[i][j] = 1;
                    }
                }
                else {
                    if(liveNeighbor == 3) {
                        board[i][j] = 1;
                    }
                    else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public int getLiveNeighbor(int[][] board, int i, int j) {
        int liveNeighbor = 0;
        if(i-1 >= 0) {
            if(j-1 >= 0) {
                if(board[i-1][j-1] == 1) liveNeighbor++; // upper left
            }
            if(board[i-1][j] == 1) liveNeighbor++; // up
            if(j+1 < board[0].length) {
                if(board[i-1][j+1] == 1) liveNeighbor++; // upper right
            }
        }
        if(i+1 < board.length) {
            if(j-1 >= 0) {
                if(board[i+1][j-1] == 1) liveNeighbor++; // lower left
            }
            if(board[i+1][j] == 1) liveNeighbor++; // down
            if(j+1 < board[0].length) {
                if(board[i+1][j+1] == 1) liveNeighbor++; // lower right
            }
        }
        if(j-1 >= 0) {
            if(board[i][j-1] == 1) liveNeighbor++;
        }
        if(j+1 < board[0].length) {
            if(board[i][j+1] == 1) liveNeighbor++;
        }
        return liveNeighbor;
    }
}