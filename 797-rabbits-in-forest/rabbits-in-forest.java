class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        int[] memo = new int[1001];
        for(int i: answers) {
            i = i + 1;
            if(memo[i] == 0) {
                res += i;
                
            }
            memo[i]++;
            memo[i] %= i;
        }
        return res;
    }
}