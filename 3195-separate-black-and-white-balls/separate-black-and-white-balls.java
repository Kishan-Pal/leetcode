class Solution {
    public long minimumSteps(String s) {
        int j = s.length() - 1;
        long steps = 0;
        for(int i=j; i>=0; i--) {
            if(s.charAt(i) == '0') continue;
            steps += j - i;
            j--;
        }
        return steps;
    }
}