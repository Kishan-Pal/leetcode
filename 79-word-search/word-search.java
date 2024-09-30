class Solution {

    public boolean search(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        boolean result;
        //System.out.println(i + " " + j + " == " + k);
        visited[i][j] = true;
        if(k == word.length()-1) return true;
        if(i>0 && !visited[i-1][j] && board[i-1][j] == word.charAt(k+1)) {
            result = search(board, i-1, j, word, k+1, visited);
            if(result) return true;
        }
        if(j<board[0].length-1 && !visited[i][j+1] && board[i][j+1] == word.charAt(k+1)) {
            result = search(board, i, j+1, word, k+1, visited);
            if(result) return true;
        }
        if(i<board.length-1 && !visited[i+1][j] && board[i+1][j] == word.charAt(k+1)) {
            result = search(board, i+1, j, word, k+1, visited);
            if(result) return true;
        }
        if(j>0 && !visited[i][j-1] && board[i][j-1] == word.charAt(k+1)) {
            result = search(board, i, j-1, word, k+1, visited);
            if(result) return true;
        }
        visited[i][j] = false;
        return false;

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean result = search(board, i, j, word, 0, visited);
                    if(result) return true;
                }
            }
        }
        return false;
    }
}