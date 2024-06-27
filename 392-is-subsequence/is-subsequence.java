class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] news = s.toCharArray();
        int j=0, k;
        for(int i=0; i<news.length; i++) {
            k = t.indexOf(news[i], j);
            if(k==-1)return false;
            j = k + 1;
        }
        return true;
    }
}