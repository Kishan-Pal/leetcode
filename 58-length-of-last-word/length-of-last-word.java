class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n-1;
        int res = 0;
        while(i >= 0 && s.charAt(i) == ' ') {
            i = i - 1;
        }
        while(i >= 0 && s.charAt(i) != ' ') {
            i = i - 1;
            res = res + 1;
        }
        return res;
    }
}