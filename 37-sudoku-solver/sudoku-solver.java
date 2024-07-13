class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int i, int j) {
        int tempi = i, tempj = j;
        for(tempi = i; tempi<9; tempi++) {
            for(; tempj<9; tempj++) {
                if(board[tempi][tempj] == '.') break;
            }
            if(tempj<9){
                break;
            }
            tempj = 0;
        }
        if(tempi == 9){
            return true;
        }
        char num;
        for(num = '1'; num <= '9'; num++) {
            if(canBePlaced(board, tempi, tempj, num)) {
                board[tempi][tempj] = num;
                if(solve(board, tempi+((tempj+1)/9), (tempj+1)%9)) return true;
                board[tempi][tempj] = '.';
            }
        }
        return false;
    }

    public boolean canBePlaced(char[][] board, int i, int j, char num) {
        int tempj = 0, tempi = 0;
        while(tempj < 9) {
            if(board[i][tempj] == num) return false;
            tempj++;
        }
        tempj = j;
        while(tempi < 9) {
            if(board[tempi][tempj] == num) return false;
            tempi++;
        }
        int limi, limj, startj;
        i = i - (i % 3);
        startj = j - (j % 3);
        limi = i + 3;
        limj = startj + 3;
        for(; i < limi; i++) {
            for(j=startj; j < limj; j++) {
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }

}