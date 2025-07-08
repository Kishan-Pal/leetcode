class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        Boolean[][] memo = new Boolean[n+1][n+1];
        ans = new ArrayList<>();
        dp(n, n, "", memo);
        return ans;

    }
    public boolean dp(int open, int close, String res, Boolean[][] memo) {
        if(open < 0 || close < 0 || memo[open][close] != null && memo[open][close] == false) return false;
        if(open > close) {
            memo[open][close] = false;
            return true;
        } 
        if(open == 0 && close == 0) {
            ans.add(res);
            memo[open][close] = true;
            return true;
        }
        boolean ansOpen = dp(open - 1, close, res+'(', memo);
        boolean ansClose = dp(open, close - 1, res+')', memo);
        memo[open][close] = ansOpen || ansClose;

        return memo[open][close];



    }
}