class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        for(int i=n-1; i>=0; i--) {
            //System.out.println((int)columnTitle.charAt(i)-64);
            res = res + (int)Math.pow(26, n-i-1) * ((int)columnTitle.charAt(i)-64);
            //System.out.println(res);
        }
        return res;
    }
}