class Solution {
    public char findTheDifference(String s, String t) {
        char[] news = s.toCharArray();
        char[] newt = t.toCharArray();
        int res = 0;
        for(int i=0; i<news.length; i++) {
            res ^= (int)news[i];
        }
        for(int i=0; i<newt.length; i++) {
            res ^= (int)newt[i];
        }
        return (char)res;
    }
}