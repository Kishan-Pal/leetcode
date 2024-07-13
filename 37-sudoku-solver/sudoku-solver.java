class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        //System.out.println(solve(board, 0, 0));
        //board[2][0] = '1';
        //System.out.println(this.canBePlaced(board, 6, 0, '1'));
    }

    public boolean solve(char[][] board, int i, int j) {
        int tempi = i, tempj = j;
        for(tempi = i; tempi<9; tempi++) {
            for(; tempj<9; tempj++) {
                //System.out.println("Checking " + tempi + " " + tempj + " " + board[tempi][tempj]);
                if(board[tempi][tempj] == '.') break;
            }
            if(tempj<9){
                //System.out.println("Solving " + tempi + " " + tempj + " " + board[tempi][tempj]);
                break;
            }
            tempj = 0;
        }
        if(tempi == 9){
            //this.printSudoku(board);
            return true;
        }
        char num;
        for(num = '1'; num <= '9'; num++) {
            if(canBePlaced(board, tempi, tempj, num)) {
                board[tempi][tempj] = num;
                //System.out.println(tempi + " " + tempj + " = " + num);
                if(solve(board, tempi+((tempj+1)/9), (tempj+1)%9)) return true;
                //System.out.println("Resetting " + tempi + " " + tempj + " from " + board[tempi][tempj]);
                board[tempi][tempj] = '.';
                //System.out.println(tempi + " " + tempj + " = '.'");
            }
        }
        return false;
    }

    public boolean canBePlaced(char[][] board, int i, int j, char num) {
        int tempj = 0, tempi = 0;
        while(tempj < 9) {
            //System.out.print(board[tempi][tempj] + " ");
            if(board[i][tempj] == num) return false;
            tempj++;
        }
        //System.out.println();
        tempj = j;
        //tempi = i;
        while(tempi < 9) {
            //System.out.print(board[tempi][tempj] + " ");
            if(board[tempi][tempj] == num) return false;
            tempi++;
        }
        //System.out.println();
        //tempi = i;
        int limi, limj, startj;
        i = i - (i % 3);
        startj = j - (j % 3);
        limi = i + 3;
        limj = startj + 3;
        for(; i < limi; i++) {
            for(j=startj; j < limj; j++) {
                //System.out.print(board[i][j] + " ");
                //System.out.println(i + " " + j );
                if(board[i][j] == num) return false;
            }
        }
        //System.out.println();
        return true;
    }

    public void printSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}