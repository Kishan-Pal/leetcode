class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()+1];
        return dp(0, s);
    }
    public int dp(int i, String s) {
        if(i == s.length()) return 1;
        if(i > s.length()) return 0;
        if(s.charAt(i) == '0') return 0;
        if(memo[i] != 0) return memo[i];
        int ways1 = dp(i+1, s);
        int ways2 = 0;
        if(i < s.length()-1) {
            
            int num = Integer.valueOf(s.substring(i, i+2));
            if(num <= 26 && num >=1) {
                ways2 = dp(i+2, s);
            }
        }
        memo[i] = ways1 + ways2;
        return memo[i];
    }
}